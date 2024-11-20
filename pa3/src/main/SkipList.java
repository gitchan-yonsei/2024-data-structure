/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class SkipList<K> implements ISkipList<K> {
    private ICoin coin;
    private Comparator<K> comp;
    private int size;

    public final MetaVar PosInf = new MetaVar(null, 1);
    public final MetaVar NegInf = new MetaVar(null, -1);
    // you may declare additional variables here.

    private QuadNode head; // top-left node
    private int levels;

    class MetaVar implements Comparable<MetaVar> {
        private int isInf;
        private K value;

        public MetaVar(K value, int isInf) {
            this.value = value;
            this.isInf = isInf;
        }

        public MetaVar(K value) {
            this.value = value;
            this.isInf = 0;
        }

        public int hashCode() {
            return value.hashCode();
        }

        public int compareTo(MetaVar v) {
            if (this.isInf == 0 && v.isInf == 0) {
                return comp.compare(this.value, v.value);
            } else {
                if (this.isInf < v.isInf) return -1;
                else if (this.isInf > v.isInf) return 1;
                else return 0;
            }
        }

        public String toString() {
            if (isInf > 0) {
                return "+inf";
            } else if (isInf < 0) {
                return "-inf";
            } else return value.toString();
        }
    }

    class QuadNode {
        public MetaVar value;

        public QuadNode up, down, left, right;

        private QuadNode(MetaVar val) {
            this.value = val;
            up = down = left = right = null;
        }
    }

    public SkipList(ICoin coin, Comparator<K> comp) {
        /*
         * Constructor.
         * ICoin coin provides the following operation:
         *  + coin.toss(): return true if the tossing result is tail
         *
         * you MUST use the coin object to decide on stacking nodes.
         * you also must use comp object to compare two keys.
         *
         * note that we will check the number of compare calls;
         * if the count is too low or too high (depending on cases),
         * you will fail the case.
         */
        this.coin = coin;
        this.comp = comp;
        this.size = 0;
        this.levels = 0;

        // Initialize the skip list with the top-level head and tail
        QuadNode negInf = new QuadNode(NegInf);
        QuadNode posInf = new QuadNode(PosInf);
        negInf.right = posInf;
        posInf.left = negInf;

        this.head = negInf;
    }

    @Override
    public int size() {
        /*
         * Input: none
         *
         * Output: the number of elements in the skip list
         */
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /*
         * Input: none
         *
         * Output: whether or not the map is empty
         */
        return size() == 0;
    }

    @Override
    public void add(K key) {
        /*
         * Input: a key to be added
         *
         * Output: none
         *
         * Does:
         *  - insert the key in the skiplist.
         *  - if the key is already in this data structure, silently ignore the request.
         */
        MetaVar newKey = new MetaVar(key);
        QuadNode curr = head;

        // Traverse to find the correct position
        while (true) {
            while (curr.right != null && curr.right.value.compareTo(newKey) < 0) {
                curr = curr.right;
            }

            if (curr.down != null) {
                curr = curr.down;
            } else {
                break; // Reached bottom level
            }
        }

        // Insert node at the bottom level
        QuadNode newNode = new QuadNode(newKey);
        newNode.right = curr.right;
        if (curr.right != null) {
            curr.right.left = newNode;
        }
        newNode.left = curr;
        curr.right = newNode;

        // Handle upper levels
        int level = 1;
        while (coin.toss()) {
            level++;

            if (level > levels) {
                levels++;

                // Create a new top level
                QuadNode negInf = new QuadNode(NegInf);
                QuadNode posInf = new QuadNode(PosInf);

                negInf.right = posInf;
                posInf.left = negInf;

                negInf.down = head;
                head.up = negInf;

                posInf.down = head.right;
                head.right.up = posInf;

                head = negInf;
            }

            while (curr.up == null) {
                curr = curr.left;
            }
            curr = curr.up;

            QuadNode upperNode = new QuadNode(newKey);
            upperNode.down = newNode;
            newNode.up = upperNode;

            upperNode.right = curr.right;
            if (curr.right != null) {
                curr.right.left = upperNode;
            }
            upperNode.left = curr;
            curr.right = upperNode;

            newNode = upperNode;
        }

        size++;
    }

    @Override
    public void delete(K key) {
        /*
         * Input: a key to be deleted.
         *
         * Output: none
         *
         * Does:
         *  - delete the key from the structure.
         *  - if the key is NOT in the structure, ignore the request.
         */
        MetaVar target = new MetaVar(key);
        QuadNode curr = head;

        // Traverse to find the node
        while (true) {
            while (curr.right != null && curr.right.value.compareTo(target) < 0) {
                curr = curr.right;
            }

            if (curr.right != null && curr.right.value.compareTo(target) == 0) {
                QuadNode toDelete = curr.right;

                // Remove the node at all levels
                while (toDelete != null) {
                    toDelete.left.right = toDelete.right;
                    if (toDelete.right != null) {
                        toDelete.right.left = toDelete.left;
                    }

                    toDelete = toDelete.up;
                }

                this.size--;
                return;
            }

            if (curr.down != null) {
                curr = curr.down;
            } else {
                break; // Not found
            }
        }
    }

    @Override
    public boolean contain(K key) {
        /*
         * Input: a key to be checked.
         *
         * Output: whether or not the skip list contains the value
         */
        MetaVar target = new MetaVar(key);
        QuadNode current = head;

        while (true) {
            while (current.right.value.compareTo(target) < 0) {
                current = current.right;
            }

            if (current.right.value.compareTo(target) == 0) {
                return true;
            }

            if (current.down != null) {
                current = current.down;
            } else {
                return false;
            }
        }
    }

    @Override
    public List<K> getEntries() {
        /*
         * Input: none
         *
         * Output: the entries in the skiplist.
         *
         * Does:
         *  - return the entries in the skiplist.
         *  - the list items must be in sorted order.
         *  - note that you can use ArrayList.
         */
        List<K> result = new ArrayList<>();
        QuadNode current = head;

        // Go to the bottom level
        while (current.down != null) {
            current = current.down;
        }

        // Traverse the bottom level and collect keys
        current = current.right;
        while (current.value.isInf == 0) { // Skip +inf
            result.add(current.value.value);
            current = current.right;
        }

        return result;
    }
}


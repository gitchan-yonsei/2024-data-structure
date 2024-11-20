/*
 * Name:
 * Student ID #:
 */

import java.lang.Math;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

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
        
        public int hashCode() { return value.hashCode(); }
        
        public int compareTo(MetaVar v) {
            if (this.isInf == 0 && v.isInf == 0) {
                return comp.compare(this.value, v.value);
            }
            else {
                if (this.isInf < v.isInf) return -1;
                else if (this.isInf > v.isInf) return 1;
                else return 0;
            }
        }
        
        public String toString() {
            if (isInf > 0) { return "+inf"; }
            else if (isInf < 0) { return "-inf"; }
            else return value.toString();
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
    }

    @Override
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the skip list
		 */
        return -1;
    }

    @Override
    public boolean isEmpty() {
        /*
		 * Input: none
		 *
		 * Output: whether or not the map is empty
		 */
        return false;
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
        return;
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
        return;
    }

    @Override
    public boolean contain(K key) {
        /*
         * Input: a key to be checked.
         * 
		 * Output: whether or not the skip list contains the value
         */
        return false;
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
        return null;
    }
}


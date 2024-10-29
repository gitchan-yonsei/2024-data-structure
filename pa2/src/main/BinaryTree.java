/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class BinaryTree<T> implements IBinaryTree<T> {
    private Node<T> rootNode;
    private int treeSize;
    // you may declare additional variables here.

    public BinaryTree() {
        this.rootNode = null;
        this.treeSize = 0;
        // you may further implement your constructor here.
    }

    @Override
    public int size() {
        /*
         * Input: none
         *
         * Output: the number of elements in the tree
         */
        return treeSize;
    }

    @Override
    public boolean isEmpty() {
        /*
         * Input: none
         *
         * Output: whether or not the tree is empty
         */
        return treeSize == 0;
    }

    @Override
    public Node<T> getRoot() {
        /*
         * Input: none
         *
         * Output: the root node of the tree
         *
         * Does:
         *  - return the root node of the tree.
         *  - if the tree is empty, return null.
         */
        if (isEmpty()) {
            return null;
        }
        return rootNode;
    }

    @Override
    public void insert(T element, String position) {
        /*
         * Input: an element to be inserted to the tree, a binary string consisting of the alphabets 'l' and 'r' with lowercase
         *
         * Output: none
         *
         * Does:
         *  - read each character of a string composed of 'l' and 'r' to find the corresponding node position.
         *  - an empty string refers to the root node, where "l" means to go to the left child node and "r" means to go to the right child node.
         *  - if the corresponding node already exists, replace its value with the given element.
         *  - if the corresponding node does not exist but the parent node does, create a new node at that position and insert the given element.
         *  - if the parent node does not exist, do nothing.
         */
        if (position.isEmpty()) {
            if (rootNode == null) {
                rootNode = new Node<>(element);
                this.treeSize++;
                return;
            }
            rootNode.setValue(element);
            return;
        }

        Node<T> curr = rootNode;
        for (int i = 0; i < position.length(); i++) {
            if (curr == null) {
                return;
            }
            final char direction = position.charAt(i);
            if (direction == 'l') {
                if (i == position.length() - 1 && curr.getLeft() == null) {
                    curr.setLeft(new Node<>(element));
                    this.treeSize++;
                }
                curr = curr.getLeft();
            }
            if (direction == 'r') {
                if (i == position.length() - 1 && curr.getRight() == null) {
                    curr.setRight(new Node<>(element));
                    this.treeSize++;
                }
                curr = curr.getRight();
            }
        }

        // if the corresponding node already exists, replace its value with the given element.
        if (curr != null) {
            curr.setValue(element);
        }
    }

    @Override
    public T pop(String position) {
        /*
         * Input: none
         *
         * Output: the element in the removed node
         *
         * Does:
         *  - read each character of a string composed of 'l' and 'r' to find the corresponding node position.
         *  - an empty string refers to the root node, where "l" means to go to the left child node and "r" means to go to the right child node.
         *  - if the corresponding node exists and is an external node, delete that node and return its value.
         *  - if the corresponding node is an internal node or does not exist, return null.
         */

        // 루트 노드 삭제
        if (position.isEmpty()) {
            if (this.rootNode == null) {
                return null;
            }

            final T value = this.rootNode.getValue();
            this.rootNode = null;
            this.treeSize--;
            return value;
        }

        Node<T> curr = rootNode;
        Node<T> parent = null;
        char direction = ' ';

        for (int i = 0; i < position.length(); i++) {
            direction = position.charAt(i);

            if (curr == null) {
                return null;
            }

            if (direction == 'l') {
                parent = curr;
                curr = curr.getLeft();
            } else if (direction == 'r') {
                parent = curr;
                curr = curr.getRight();
            } else {
                return null;
            }
        }

        // 노드가 null인 경우
        if (curr == null) {
            return null;
        }

        // internal node인 경우
        if (curr.isInternal()) {
            return null;
        }

        // external node 삭제
        final T value = curr.getValue();
        if (parent != null) {
            if (direction == 'l') {
                parent.setLeft(null);
            }
            if (direction == 'r') {
                parent.setRight(null);
            }
        }
        this.treeSize--;

        return value;
    }
}

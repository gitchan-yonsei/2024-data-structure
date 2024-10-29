/*
 * Name:
 * Student ID #:
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
        return -1;
    }

    @Override
    public boolean isEmpty() {
        /*
		 * Input: none
		 *
		 * Output: whether or not the tree is empty
		 */
        return true;
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
        return null;
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
        return;
    }

    @Override
    public T pop(String position){
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
        return null;
    }
}

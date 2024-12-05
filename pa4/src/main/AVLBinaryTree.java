/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class AVLBinaryTree implements IAVLBinaryTree {
    private BinaryNode root;
    private int size;
    // you may declare additional variables here.

    public AVLBinaryTree(){
        this.size = 0;
        this.root = null;
        // implement your constructor here.
    }

    @Override 
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the tree.
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
        return false;
    }

    @Override
    public int getHeight() {
        /*
		 * Input: none
		 *
		 * Output: the height of the tree
		 */
        return -1;
    }

    @Override 
    public boolean contains(int val) {
        /*
		 * Input: an integer value
		 *
		 * Output: whether or not the tree contains the value.
		 */
        return false;
    }

    @Override
    public void put(int val) {
        /*
		 * Input: an integer value to insert
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - if the given value is in the tree, do nothing.
         *  - if the key is not found, insert a new node following the property of binary search tree.
         *  - after insertion, re-balance the tree to satisfy the height-balance property.
		 */
        return;
    }

    @Override
    public void remove(int val) {
        /*
		 * Input: an integer value to remove
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - check whether the given value is in the tree.
         *  - if the key is not found, do nothing.
         *  - if the given value is in the tree, remove the value.
         *  - after removal, rebalance the tree to satisfy the height-balance property.
		 */
        return;
    }
}

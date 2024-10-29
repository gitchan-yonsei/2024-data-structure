/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class MinHeap implements IMinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    // you may declare additional variables here.

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
        // you may further implement your constructor here. the default constructor is not required.
    }

    @Override
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the heap
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
    public void add(int value) {
        /*
		 * Input: an integer to be added to the heap
		 *
		 * Output: none
         * 
         * Does:
         *  - add the given integer to the heap
         *  - if the heap is full, do not add.
         *  - the heap should maintain the heap property after adding.
		 */
        return;
    }

    @Override
    public int pop() {
        /*
		 * Input: none
		 *
		 * Output: the smallest integer of the heap
         * 
         * Does:
         *  - remove and return the smallest integer of the heap.
         *  - if the heap is empty, return -1.
         *  - the heap should maintain the heap property after popping.
		 */
        return -1;
    }
}

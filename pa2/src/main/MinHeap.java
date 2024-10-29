/*
 * Name: 조은기
 * Student ID #: 2019147029
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        /*
         * Input: none
         *
         * Output: whether or not the tree is empty
         */
        return size == 0;
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
        if (capacity == size) {
            return;
        }

        // add at the last leaf
        heap[size] = value;
        int currIndex = size;
        this.size++;

        // heapify up
        while (currIndex > 0 && heap[currIndex] < heap[(currIndex - 1) / 2]) {
            int parentIndex = (currIndex - 1) / 2;

            final int tmp = heap[currIndex];
            heap[currIndex] = heap[parentIndex];
            heap[parentIndex] = tmp;

            currIndex = parentIndex;
        }
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

        // if the heap is empty, return -1.
        if (isEmpty()) {
            return -1;
        }

        // put last node to the root node
        final int rootValue = heap[0];
        heap[0] = heap[size - 1];
        this.size--;

        // heapify down
        int currIndex = 0;
        while (true) {
            final int leftChildIndex = 2 * currIndex + 1;
            final int rightChildIndex = 2 * currIndex + 2;
            int smallestIndex = currIndex;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex == currIndex) {
                break;
            }

            final int tmp = heap[currIndex];
            heap[currIndex] = heap[smallestIndex];
            heap[smallestIndex] = tmp;

            currIndex = smallestIndex;
        }

        return rootValue;
    }
}

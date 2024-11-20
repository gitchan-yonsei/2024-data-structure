/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class NaturalNumberSet implements INaturalNumberSet {
    private DoubleHashFunction func;
    private int[] set;
    private int size;
    private int N;
    // you may declare additional variables here.

    public NaturalNumberSet(int N, int q){
        this.func = new DoubleHashFunction(N, q);
        this.size = 0;
        this.set = new int[N];
        this.N = N;
        // implement your constructor here. the default constructor is not required.
    }

    @Override 
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the set
		 */
        return -1;
    }

    @Override 
    public boolean isEmpty() {
        /*
		 * Input: none
		 *
		 * Output: whether or not the set is empty
		 */
        return false;
    }

    @Override 
    public boolean contains(int val) {
        /*
		 * Input: a natural number
		 *
		 * Output: whether or not the set contains the value
		 */
        return false;
    }

    @Override
    public boolean add(int val) {
        /*
		 * Input: a natural number to be added to the set
		 *
		 * Output: whether the value is in the set or not after terminating
		 * 
		 * Does:
		 *  - check whether the value is in the set.
         *  - if it is, return true; otherwise, add it to the set and return true.
         *  - if the set is full, do nothing.
         *  - return whether the value is in the set or not after terminating
		 */
        return false;
    }

    @Override
    public int remove(int val) {
        /*
		 * Input: a natural number to be removed to the set
		 *
		 * Output: an integer
		 * 
		 * Does:
		 *  - remove and return the given natural number from the set.
         *  - if the value is not in the set, return -1
		 */
        return -1;
    }
    
    @Override
    public int[] iterator() {
        /*
		 * Input: none
		 *
		 * Output: an integer array containing all natural numbers in the set
		 * 
		 * Does:
		 *  - create an integer array with size of the number of elements in the set.
         *  - copy elements to the integer array and return it.
		 */
        return null;
    }

    @Override
    public void addAll(INaturalNumberSet T){
        /*
		 * Input: a natural number set
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - add all elements in the given set to this set.
		 */
        return;
    }
    
    @Override
    public void retainAll(INaturalNumberSet T){
        /*
		 * Input: a natural number set
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - remove elements in this set that is not in the given set.
		 */
        return;
    }
    
    @Override
    public void removeAll(INaturalNumberSet T){
        /*
		 * Input: a natural number set
		 *
		 * Output: none
		 * 
		 * Does:
		 *  - remove elements in this set that is in the given set.
		 */
        return;
    }
}
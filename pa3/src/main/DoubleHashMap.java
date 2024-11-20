/*
 * Name:
 * Student ID #:
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class DoubleHashMap implements IDoubleHashMap {
    private DoubleHashFunction func;
    private HashData[] map;
    private int size;
    private int N;
    // you may declare additional variables here.

    public DoubleHashMap(int N, int q){
        this.func = new DoubleHashFunction(N, q);
        this.size = 0;
        this.map = new HashData[N];
        this.N = N;
        // implement your constructor here. the default constructor is not required.
    }

    @Override 
    public int size() {
        /*
		 * Input: none
		 *
		 * Output: the number of elements in the map
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
    public String get(int key) {
        /*
		 * Input: a nonnegative integer key
		 *
		 * Output: a string corresponding to the given key
		 * 
		 * Does:
		 *  - find and return the string associated with the given key.
         *  - if the map does not contain the key, return null.
		 */
        return null;
    }

    @Override
    public String put(int key, String val) {
        /*
		 * Input: a nonnegative integer key and a string
		 *
		 * Output: a string
		 * 
		 * Does:
		 *  - if the given key is in the map, change its value with the given string and then return the old value.
         *  - if the key is not found, add a HashData to the map using double hash and then return null.
         *  - if the map is full, return null.
		 */
        return null;
    }

    @Override
    public String remove(int key) {
        /*
		 * Input: a nonnegative integer key
		 *
		 * Output: a string
		 * 
		 * Does:
		 *  - replace the data of the given key with the data made by default constructor.
         *  - return the string value in the removed data.
         *  - if the key is not in the set, return null.
		 */
        return null;
    }
}

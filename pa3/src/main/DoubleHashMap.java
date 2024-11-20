/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class DoubleHashMap implements IDoubleHashMap {

    private static final int DEFUNCT = -1;

    private DoubleHashFunction func;
    private HashData[] map;
    private int size;
    private int N;
    // you may declare additional variables here.

    public DoubleHashMap(int N, int q) {
        this.func = new DoubleHashFunction(N, q);
        this.size = 0;
        this.map = new HashData[N];
        this.N = N;
        // implement your constructor here. the default constructor is not required.
        for (int i = 0; i < N; i++) {
            map[i] = new HashData(DEFUNCT, null);
        }
    }

    @Override
    public int size() {
        /*
         * Input: none
         *
         * Output: the number of elements in the map
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
        final int h1 = func.firstHash(key); // h1(k) = key % N
        final int d = func.secondHash(key); // d(k) = q - (key % q)

        // (h1 + j * d) % N
        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;
            final HashData currData = map[index];

            if (currData.getKey() == key) {
                return currData.getValue();
            }

            if (currData.getKey() == DEFUNCT) {
                break;
            }
        }

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
        final int h1 = func.firstHash(key); // h1(k) = key % N
        final int d = func.secondHash(key); // d(k) = q - (key % q)

        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;
            final HashData currData = map[index];

            if (currData.getKey() == DEFUNCT) {
                map[index] = new HashData(key, val);
                this.size++;
                return null;
            }

            if (currData.getKey() == key) {
                final String currValue = currData.getValue();
                map[index] = new HashData(key, val);
                return currValue;
            }
        }

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

        final int h1 = func.firstHash(key); // h1(k) = key % N
        final int d = func.secondHash(key); // d(k) = q - (key % q)

        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;
            final HashData currData = map[index];

            if (currData.getKey() == key) {
                final String currValue = currData.getValue();
                map[index] = new HashData(DEFUNCT, null);
                this.size--;
                return currValue;
            }

            if (currData.getKey() == DEFUNCT) {
                break;
            }
        }

        return null;
    }
}

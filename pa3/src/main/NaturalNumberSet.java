/*
 * Name: 조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class NaturalNumberSet implements INaturalNumberSet {

    private static final int DEFUNCT = -1;

    private DoubleHashFunction func;
    private int[] set;
    private int size;
    private int N;
    // you may declare additional variables here.

    public NaturalNumberSet(int N, int q) {
        this.func = new DoubleHashFunction(N, q);
        this.size = 0;
        this.set = new int[N];
        this.N = N;
        // implement your constructor here. the default constructor is not required.

        // Initialize the set with DEFUNCT
        for (int i = 0; i < N; i++) {
            set[i] = DEFUNCT;
        }
    }

    @Override
    public int size() {
        /*
         * Input: none
         *
         * Output: the number of elements in the set
         */
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /*
         * Input: none
         *
         * Output: whether or not the set is empty
         */
        return size() == 0;
    }

    @Override
    public boolean contains(int val) {
        /*
         * Input: a natural number
         *
         * Output: whether or not the set contains the value
         */
        final int h1 = func.firstHash(val);
        final int d = func.secondHash(val);

        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;

            if (set[index] == val) {
                return true;
            }

            if (set[index] == DEFUNCT) {
                return false;
            }
        }

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
        // Already in a set
        if (contains(val)) {
            return true;
        }

        if (size == N) {
            return false;
        }

        final int h1 = func.firstHash(val);
        final int d = func.secondHash(val);

        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;

            if (set[index] == DEFUNCT) {
                set[index] = val;
                this.size++;
                return true;
            }
        }
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
        final int h1 = func.firstHash(val);
        final int d = func.secondHash(val);

        for (int j = 0; j < N; j++) {
            final int index = (h1 + j * d) % N;

            if (set[index] == val) {
                set[index] = DEFUNCT;
                this.size--;
                return val;
            }

            if (set[index] == DEFUNCT) {
                break; // Value not found
            }
        }

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
        int[] content = new int[size];
        int index = 0;
        for (int i = 0; i < N; i++) {
            final int val = set[i];
            if (val != DEFUNCT && val != 0) {
                content[index++] = val;
            }
        }

        return content;
    }

    @Override
    public void addAll(INaturalNumberSet T) {
        /*
         * Input: a natural number set
         *
         * Output: none
         *
         * Does:
         *  - add all elements in the given set to this set.
         */
        final int[] elements = T.iterator();
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    @Override
    public void retainAll(INaturalNumberSet T) {
        /*
         * Input: a natural number set
         *
         * Output: none
         *
         * Does:
         *  - remove elements in this set that is not in the given set.
         */
        final int[] elements = iterator();
        for (int i = 0; i < elements.length; i++) {
            final int val = elements[i];
            if (!T.contains(val)) {
                remove(val);
            }
        }
    }

    @Override
    public void removeAll(INaturalNumberSet T) {
        /*
         * Input: a natural number set
         *
         * Output: none
         *
         * Does:
         *  - remove elements in this set that is in the given set.
         */
        final int[] elements = T.iterator();
        for (int i = 0; i < elements.length; i++) {
            final int val = elements[i];
            remove(val);
        }
    }
}

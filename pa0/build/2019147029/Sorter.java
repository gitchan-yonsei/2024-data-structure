/*
 * Name:　조은기
 * Student ID #: 2019147029
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class Sorter implements ISorter {
    public Sorter() { ; }

    @Override
    public int[] ascending(int[] a) {
        final int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] >= a[j + 1]) {
                    final int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }

    @Override
    public int[] descending(int[] a) {
        final int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] <= a[j + 1]) {
                    final int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }
}

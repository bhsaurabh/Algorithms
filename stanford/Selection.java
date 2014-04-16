public class Selection {
    /* Selection sort algorithm */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    /* API: Sorting within a range */
    public static void sort(Comparable[] a, int lo, int hi) {
        // grab the correct entry from the right and position it in current position
        for (int i = lo; i <= hi; i++) {
            int max = i;
            for (int j = i; j <= hi; j++)
                if (less(a[max], a[j]))
                    max = j;
            exch(a, i, max);
        }
    }

    /* Helper: Is p < q? */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /* Helper: Exchange elements at i and j */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

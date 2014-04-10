public class Merge {
    /* An implementation of Merge sort */

    /* Application entry point */
    public static void sort(Comparable[] a) {
        // Step 1: Create auxiliary array to copy elements into
        // Creating here is useful as we avoid repetitive creation
        Comparable[] aux = new Comparable[a.length];
        // Step 2: Pass to recursive routine
        sort(a, aux, 0, a.length-1);
    }

    /* Recursive sorting routine */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // Step 1: Check for bounds
        if (hi <= lo)   return;
        // Step 2: Use insertion sort for small array sizes
        if (hi <= lo + 7)   Insertion.sort(a, lo, hi);
        // Step 3: Calculate mid point and recursively sort sub arrays
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        // Merge sorted sub arrays
        merge(a, aux, lo, mid, hi);
    }

    /* Merge 2 sorted sub arrays in linear time*/
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // assert that the 2 sub arrays are really sorted
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // Step 1: Copy all elements into auxiliary array
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];
        // Step 2: Copy elements in order from auxiliary array into primary array
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)    a[k] = aux[j++];
            else if (j > hi)    a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else    a[k] = aux[j++];
        }

        // Step 3: Assert that the final merged array is sorted
        assert isSorted(a, lo, hi);
    }

    /* Helper: Check if p < q */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /* Helper: Check if an array is sorted */
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++)
            if (less(a[i+1], a[i])) return false;
        return true;
    }
}

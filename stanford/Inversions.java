public class Inversions {
    /* Counts the number of inversions in an array
     * Uses a method vaguely similar to mergesort */

    private static boolean debug = false;

    /* API: Count and return number of inversions */
    public static int countInversions(Comparable[] a) {
        // create an auxiliary array
        Comparable[] aux = new Comparable[a.length];
        int count = sortAndCount(a, aux, 0, a.length-1);
        if (debug) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + "\t");
            System.out.println();
        }
        return count;
    }

    /* Recursive method to sort the array and count number of inversions */
    private static int sortAndCount(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)   return 0;

        int mid = (lo + hi) / 2;
        // sort and count left inversions
        int left = sortAndCount(a, aux, lo, mid);
        // sort and count right inversions
        int right = sortAndCount(a, aux, mid+1, hi);
        // merge and count split inversions
        if (debug) {
            System.out.println("Merging ( " + lo + " " + hi + " ): ");
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + "\t");
            System.out.println();
        }
        int split = mergeAndCountSplit(a, aux, lo, mid, hi);
        // return all inversions
        if (debug) {
            System.out.println("Returning ( " + lo + " " + hi + " ): ");
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + "\t");
            System.out.println();
        }
        return (left + right + split);
    }

    /* Linear time merging and counting of split inversions */
    private static int mergeAndCountSplit(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // assert that the sub arrays are sorted
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy all elements from a to aux
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];

        // maintain a count of number of split inversions
        int splitInversions = 0;

        // do a merge and count
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            // boundary check
            if (i > mid)    a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[i++];
            else {
                // copy element into a
                a[k] = aux[j++];
                // this is where split inversions are
                splitInversions += (mid - i + 1);
            }
            if (debug)
                System.out.println("a[k]: " + a[k]);
        }

        // assert that entire array is sorted
        assert isSorted(a, lo, hi);
        return splitInversions;
    }

    /* Helper: Is p < q? */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /* Helper: Is array sorted? */
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++)
            if (less(a[i+1], a[i])) return false;
        return true;
    }
}

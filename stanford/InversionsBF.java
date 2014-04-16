public class InversionsBF {
    /* Brute force approach to finding number of inversions */
    // O(n^2) = O(n(n-1)/2)
    private static boolean debug = false;

    public static int countInversions(Comparable[] a) {
        return countInversions(a, 0, a.length-1);
    }

    public static int countInversions(Comparable[] a, int lo, int hi) {
        // iterate through every index
        // check every larger index to search for an inversion
        int count = 0;
        for (int i = lo; i < hi; i++)
            for (int j = i+1; j <= hi; j++) 
                if (less(a[j], a[i])){
                    count++;
                    if (debug)
                        System.out.println(a[i] + " <-> " + a[j]);
                }
            
        return count;
    }

    /* Helper: Check if p < q */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }
}

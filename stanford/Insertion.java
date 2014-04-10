public class Insertion {
    /* An implementation of insertion sort */
    
    /* Application entry point */
    public static void sort(Comparable[] a) {
        sort(a,0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        // sort from lo to hi...place a[i] in correct position
        for (int i = lo; i <= hi; i++) {
            for (int j = i; i > lo; i--) {
                if (less(a[j], a[j-1])) exch(a, j, j-1);
                else    break;
            }   
        }
    }

    /* Helper: Check if p < q */
    private static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    /* Helper: Exchange elements at position p and q */
    private static void exch(Comparable[] a, int p, int q) {
        Comparable swap = a[p];
        a[p] = a[q];
        a[q] = swap;
    }
}

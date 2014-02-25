public class Selection
{
    /* An implementation of Selection sort*/
    
    public static void sort(Comparable[] a)
    {
        // O(N2/2) compares and O(N) exchanges
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            // Array to the left is sorted
            // Get minimum element on right and swap
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[i]))
                    min = j;
            // put minimum in place
            exch(a, i, min);
        }
        
        assert isSorted(a, 0, a.length-1);
    }
    
    protected static boolean less(Comparable p, Comparable q)
    {
        return p.compareTo(q) < 0;
    }
    
    protected static void exch(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    protected static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo; i < hi; i++)
            if (less(a[i+1], a[i]))
                return false;
        return true;
    }
}
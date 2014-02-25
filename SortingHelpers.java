public class SortingHelpers
{
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
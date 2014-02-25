public class Insertion extends SortingHelpers
{
    /* An implementation of Insertion Sort*/

    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length-1);
    }
    
    public static void sort(Comparable[] a, int lo, int hi)
    {
        // O(N2/4) compares and O(N2/4) exchanges
        for (int i = lo; i <= hi; i++)
        {
            // swap current element int correct place
            for (int j = i; j > lo; j--)    // else a[j-1] not defined
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;
        }
        assert isSorted(a, lo, hi);
    }
}
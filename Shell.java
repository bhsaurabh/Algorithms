public class Shell extends SortingHelpers
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        
        int h = 1;
        while (h < N/3) h = 3*h+1;
        
        while (h >= 1)
        {
            // do multiple h-sorts
            for (int i = h; i < N; i++)
                for (int j = i; j >= h; j--)
                    if (less(a[j], a[j-h]))
                        exch(a, j, j-h);
        
            h = h/3;
        }
    }
}
public class Quick extends SortingHelpers
{
	// Quick sort
	public static void sort(Comparable[] a)
	{
		// randomly shuffle the array for probablistic guarantee
		Knuth.shuffle(a);
		// no auxiliary array is needed here
		sort(a, 0, a.length-1);
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{
		// choose a[lo] as partition element
		int i = lo, j = hi+1;
		while (true)
		{
			// increment i as long as a[i] < a[lo]
			while (less(a[++i], a[lo]))
				if (i == hi)	break;

			// decrement j as long as a[j] > a[lo]
			while (less(a[lo], a[--j]))
				if (j == lo)	break;

			// check if pointers cross
			if (i >= j)	break;

			// swap pointer values
			exch(a, i, j);
		}
		// j now points to correct location of partition element
		exch(a, lo, j);
		return j;
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		// recursive routine
		if (hi <= lo)	return;

		int CUTOFF = 10;
		if (hi <= lo + CUTOFF - 1)	
			Insertion.sort(a, lo, hi);

		int r = partition(a, lo, hi);
		// r is already in correct location
		sort(a, lo, r-1);
		sort(a, r+1, hi);		
	}
}
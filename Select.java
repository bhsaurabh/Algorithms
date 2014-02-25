public class Select extends SortingHelpers
{
	public static Comparable select(Comparable[] a, int k)
	{
		// randomly shuffle the array
		Knuth.shuffle(a);
		// let recursive routine handle
		Comparable result = select(a, k, 0, a.length-1);
		return result;
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{
		// use a[lo] as partition element
		int i = lo, j = hi+1;
		while (true)
		{
			while (less(a[++i], a[lo]))
				if (i == hi)	break;
			while (less(a[lo], a[--j]))
				if (j == lo)	break;
			// check if pointers have crossed
			if (i >= j)	break;
			exch(a, i, j);
		}
		exch(a, j, lo);
		return j;
	}

	private static Comparable select(Comparable[] a, int k, int lo, int hi)
	{
		if (hi <= lo)	return null;

		int r = partition(a, lo, hi);
		if (r == k)	return a[k];
		if (r > k)
		{
			// search left side
			select(a, k, lo, r-1);
		}
		else
		{
			// search right side
			// use effective rank=k-r
			select(a, k-r, r+1, hi);
		}
		return a[k];
	}
}
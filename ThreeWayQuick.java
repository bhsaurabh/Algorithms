public class ThreeWayQuick extends SortingHelpers
{
	// Dijkstra's Three Way Quick Sort
	
	public static void sort(Comparable[] a)
	{
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		// recursive routine for sorting
		if (hi <= lo)	return;

		int CUTOFF = 10;
		if (hi <= lo + CUTOFF - 1)
			Insertion.sort(a, lo, hi);

		int i = lo;
		int lt = lo, gt = hi;
		Comparable v = a[lo];
		while (i <= gt)
		{
			int cmp = a[i].compareTo(v);

			if (cmp < 0)
				exch(a, i++, lt++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
}
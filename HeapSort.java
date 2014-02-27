public class HeapSort
{
	/* Heapsort - ont of the best sorting algorithms
	 * in place and 2NlgN
	 * but not stable
	 * poor cache memory usage */

	public static void sort(Comparable[] a)
	{
		int N = a.length;

		// Step 1: Create a max-heap out of the given array (O(NlgN))
		for (int i = N/2; i >= 1; i--)
			sink(a, i, N);

		// Step 2: Repeatedly do delMax	//O(NlgN)
		while (N > 1)
		{
			exch(a, 1, N--);
			sink(a, 1, N);
		}

		assert SortingHelpers.isSorted(a, 0, a.length-1);
	}

	/* Helper method */
	private static void sink(Comparable[] a, int index, int N)
	{
		while (2*index <= N)
		{
			int j = 2*index;
			if (j < N && less(a, j, j+1))	j++;
			if (!less(a, index, j))	break;
			exch(a, index, j);
			index = j;
		}
	}

	/* Override less() and exch() methods to accomodate the fact that Heap starts at index 1 */
	private static boolean less(Comparable[] a, int i, int j)
	{
		return SortingHelpers.less(a[i-1], a[j-1]);
	}
	
	protected static void exch(Comparable[] a, int i, int j)
	{
		SortingHelpers.exch(a, i-1, j-1);
	}
}
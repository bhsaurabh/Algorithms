public class Merge extends SortingHelpers
{
	/* An implementation of the Merge sort algorithm */
	public static void sort(Comparable[] a)
	{
		// create an auxiliary array to hold data during merge
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		// recursive sorting routine
		if (hi <= lo)	return;

		// Insertion sort is much more efficient for small amout of data
		int CUTOFF = 7;
		if (hi <= lo + CUTOFF - 1)
			Insertion.sort(a, lo, hi);

		int mid = (lo + hi) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	} 

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);

		// copy a into aux
		for (int i = lo; i <= hi; i++)
			aux[i] = a[i];

		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)					a[k] = aux[j++];
			else if (j > hi)				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))	a[k] = aux[i++];
			else							a[k] = aux[j++];
		}

		assert isSorted(a, lo, hi);
	}
}

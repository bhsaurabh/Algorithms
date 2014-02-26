public class PQTest
{
	// tests the sorting algos
	public static void main(String[] args)
	{
		UnorderedMaxPQ pq = new UnorderedMaxPQ();
		Integer[] arr = {2, 5, 0, 1, 10, 9, -1};
		for (Integer i : arr)
			pq.insert(i);
		while (!pq.isEmpty())
			System.out.print(pq.delMax() + "\t");
		System.out.println();
	}
}
public class SortTest
{
	// tests the sorting algos
	public static void main(String[] args)
	{
		Integer[] arr = {2, 5, 0, 1, 10, 9, -1};
		ThreeWayQuick.sort(arr);
		for (int i : arr)
			System.out.print(i + "\t");
		System.out.println();
	}
}
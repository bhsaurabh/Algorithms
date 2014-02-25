public class SortTest
{
	// tests the sorting algos
	public static void main(String[] args)
	{
		Integer[] arr = {2, 5, 0, 1, 10, 9, -1};
		int toSelect = 2;
		Comparable selection = Select.select(arr, toSelect);
		System.out.println("The " + (toSelect+1) + " element from 1st is: " + selection);
		for (int i : arr)
			System.out.print(i + "\t");
		System.out.println();
	}
}
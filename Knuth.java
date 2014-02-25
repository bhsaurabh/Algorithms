import java.util.Random;
public class Knuth extends SortingHelpers
{
	// Knuth shuffle -> Linear time uniform shuffling
	public static void shuffle(Comparable[] a) 
	{
		Random rand = new Random();
		int N = a.length;
		for (int i = 0; i < N; i++)
		{
			// generate a random number in [0, i]
			int r = rand.nextInt(i+1);
			// swap
			exch(a, i, r);
		}
	}
}
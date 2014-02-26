import java.util.Random;
public class Knuth
{
	// Knuth shuffle -> Linear time uniform shuffling
	public static void shuffle(Object[] a) 
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
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

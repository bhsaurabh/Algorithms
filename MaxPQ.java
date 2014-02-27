import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>>
{
	/* 
	 * Implementation of a Max-heap
	 * Uses lgN amortized time	
	 */
	private Key[] pq;
	private int N;

	/* Constructor */
	public MaxPQ()
	{
		// Create array of capacity + 1 as index 1 is 1st element
		this.pq = (Key[]) new Comparable[1+1];
		this.N = 0;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	/* Insert into the Priority Queue */
	public void insert(Key x)
	{
		// O(lgN)
		if (++N == pq.length)	resize(N*2);
		// Step 1: Insert at end
		pq[N] = x;
		// Step 2: Promote to appropriate position
		swim(N);
	}

	/* Insertion helper */
	private void swim(int index)
	{
		// O(lgN)
		while (index > 1 && less(index/2, index))
		{
			exch(index, index/2);
			index = index / 2;
		}
	}

	/* Deletion of max element from PQ */
	public Key delMax()
	{
		// O(lgN)
		if (isEmpty())	throw new NoSuchElementException("Empty Priority Queue.");
		// Step 1: Swap pq[1] with pq[N]
		exch(1, N);
		// Step 2: Resize pq
		Key max = pq[N--];
		pq[N+1] = null;	// prevent loitering
		if (N + 1 == pq.length/4)	resize(pq.length/2);
		// Step 3: Demote pq[1] to correct position
		sink(1);
		// Step 4: Return max element
		return max;
	}

	/* Deletion helper */
	private void sink(int index)
	{
		// O(lgN)
		// look at children, swap with larger one
		while (2*index <= N)
		{
			int j = 2*index;
			if (j < N && less(j, j+1))	j++;
			if (!less(index, j))	break;
			exch(index, j);
			index = j;
		}
	}

	/* return the max element */
	public Key max()
	{
		// O(1)
		if (isEmpty())	throw new NoSuchElementException("Empty Priority Queue.");
		return pq[1];
	}

	/* Global helpers */
	private boolean less(int i, int j)
	{
		//System.out.println("Comparing: " + i + " with " + j + ". Length: " + pq.length + ". N = " + N);
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j)
	{
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private void resize(int capacity)
	{
		Key[] copy = (Key[]) new Comparable[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = pq[i];
		pq = copy; 
	}

	/* Unit testing */
	public static void main(String[] args)
	{
		MaxPQ<Integer> pq = new MaxPQ<Integer>();
		pq.insert(new Integer(1));
		pq.insert(new Integer(10));
		pq.insert(new Integer(100));
		pq.insert(new Integer(-1));
		pq.insert(new Integer(0));
		pq.insert(new Integer(-20));
		pq.insert(new Integer(32));

		// Now deletions
		while (!pq.isEmpty())
			System.out.print(pq.delMax() + "\t");
		System.out.println();
	}
}
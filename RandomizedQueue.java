import java.lang.Iterable;
import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
	private Item[] q;
	private int first, last;
	private Random rand;	// for generating random numbers

	public RandomizedQueue()
	{
		this.q = (Item[]) new Object[1];
		this.first = 0;
		this.last = 0;	// always points to the next position after last element
		this.rand = new Random();
	}

	public boolean isEmpty()
	{
		return first == 0;
	}

	public int size()
	{
		return (last - first);
	}

	/* Insert into the queue */
	public void enqueue(Item item)
	{
		if (item == null)	throw new NullPointerException("Cannot add null values.");
		if (size() == q.length)	resize(2*q.length);
		if (last == q.length)	resize(q.length);	// resizing to same size repositions the array
		// enqueue an element to the last
		q[last++] = item;
	}

	/* helpers to enqueue */
	private void resize(int capacity)
	{
		// Resizes and repositions the array to start from index 0
		Item[] copy = (Item[]) new Object[capacity];
		int size = size();
		for (int i = 0; i < size; i++)
			if (q[first+i] != null)	// as items are deleted by keeping null in deleted positions
				copy[i] = q[first + i];
		q = copy;
	}

	/* Return and delete a randomly selected value from the queue */
	public Item dequeue()
	{
		if (size() == 0)	throw new NoSuchElementException("Cannot dequeue from an empty queue.");
		// select a random value in [0, size]
		int r = rand.nextInt(size());
		int randomIndex = first + r;
		// swap with last position
		exch(randomIndex, last-1);
		// now normal dequeue
		Item item = q[--last];
		q[last] = null;
		if (size() == q.length/4)	resize(q.length/2);
		return item;
	}

	/* helpers to dequeue */
	private void exch(int i, int j)
	{
		Item swap = q[i];
		q[i] = q[j];
		q[j] = swap;
	}

	/* Select and return a random value but do not delete it. */
	public Item sample()
	{
		if (size() == 0)	throw new NoSuchElementException("Cannot sample from an empty queue.");
		// select a random value in [0, size]
		int r = rand.nextInt(size());
		int randomIndex = first + r;
		return q[randomIndex];
	}

	/* Implementation of iteration functionality */
	public Iterator<Item> iterator() { return new RandomizedQueueIterator(); }

	private class RandomizedQueueIterator implements Iterator<Item>
	{
		private Item[] qCopy;
		private int current;

		public RandomizedQueueIterator()
		{
			this.qCopy = (Item[]) new Object[size()];
			// copy the q
			for (int i = 0; i < size() ; i++)
				this.qCopy[i] = q[first + i];
			// shuffle the queue's copy
			Knuth.shuffle(this.qCopy);
			this.current = 0;
		}

		public boolean hasNext()
		{
			return current != qCopy.length;
		}

		public void remove()
		{
			// not supported
			throw new UnsupportedOperationException("remove() is not supported for iterators.");
		}

		public Item next()
		{
			if (!hasNext())	throw new NoSuchElementException("No more elements to iterate on.");
			return qCopy[current++];
		}
	}

	/* Unit testing */
	public static void main(String[] args)
	{
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		rq.enqueue("First");
		rq.enqueue("Second");
		rq.enqueue("Third");
		rq.enqueue("Fourth");
		rq.enqueue("Fifth");
		for (String s : rq)
			System.out.print(s + "\t");
		System.out.println();
		System.out.println("Sampled: " + rq.sample());
		System.out.println("Sampled: " + rq.sample());
		System.out.println("Sampled: " + rq.sample());
		System.out.println("Removed: " + rq.dequeue());
		System.out.println("Removed: " + rq.dequeue());
	}
}
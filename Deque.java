import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
	/* Node class for LL creation */
	private class Node
	{
		Item item;
		Node prev, next;
		
		public Node(Item item)
		{
			this.item = item;
			this.next = null;
			this.prev = null;
		}

		public Node(Item item, Node prev, Node next)
		{
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node first, last;
	private int size;

	/* Constructor */
	public Deque()
	{
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	/* Public method to get size of deck */
	public int size()
	{
		return size;
	}

	/* insertion operations */
	public void addFirst(Item item)
	{
		if (item == null)	throw new NullPointerException("Cannot add null values.");
		Node newNode = new Node(item, null, first);
		if (isEmpty())
			last = newNode;
		else	first.prev = newNode;
		first = newNode;
		size++;
	}

	public void addLast(Item item)
	{
		if (item == null)	throw new NullPointerException("Cannot add null values.");
		// similar to enqueue
		Node oldlast = last;
		last = new Node(item, oldlast, null);
		if (isEmpty())	first = last;
		else	oldlast.next = last;
		size++;
	}

	/* deletion operations */
	public Item removeFirst()
	{
		if (isEmpty())	throw new NoSuchElementException("Cannot remove anything from empty deck.");
		// similar to dequeue
		Item item = first.item;
		first = first.next;
		first.prev = null;
		if (isEmpty())	last = first;
		size--;
		return item;
	}

	public Item removeLast()
	{
		if (isEmpty())	throw new NoSuchElementException("Cannot remove anything from empty deck.");
		Item item = last.item;
		last = last.prev;
		last.next = null;
		if (last == null)	first = last;	// check if deck is empty
		size--;
		return item;
	}

	/* 
	 * Simple Iteration functionality
	 * Supports only forward traversal through deck
	 */
	public Iterator<Item> iterator() { return new DeckIterator(); }

	private class DeckIterator implements Iterator<Item>
	{
		private Node current = first;
		
		public boolean hasNext()
		{
			return current != null;
		}

		public void remove()
		{
			// Not supported...nor will this ever be supported!
			throw new UnsupportedOperationException("remove() not supported for iterators.");
		}

		public Item next()
		{
			// return next item in Deck
			if (!hasNext())	throw new NoSuchElementException("No elements remaining to iterate over.");
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	/* Unit testing -> Not expected to be called by client programs */
	public static void main(String[] args)
	{
		Deque<String> dq = new Deque<String>();
		dq.addFirst("First");
		dq.addLast("Last");
		dq.addFirst("newFirst");
		dq.addLast("newLast");
		System.out.println("Removed: " + dq.removeLast());
		System.out.println("Removed: " + dq.removeLast());
		for(String s:dq)
			System.out.print(s + "\t");
		System.out.println();
	}
}
import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    /* A deque(deck) generalises a stack and a queue. Can add & remove from either end */

    private class Node {
        /* Internal representation of a Node in the deck */
        private Item item;
        private Node next;  // next node in deck
        private Node prev;  // previous node in deck

        public Node(Item item) {
            this.item = item;
        }
    }

    // Pointers to keep track of the deck
    private Node first, last;
    private int size;
    public Deque() {
        /* Constructor: Initialise pointers */
        this.first = null;
        this.last = null;
        this.size = 0;  // Deck is empty initially
    }

    public boolean isEmpty() {
        /* API: Is the deck empty? */
        return first == null;
    }

    public void addFirst(Item item) {
        /* API: Insert the item to the front of the deck */
        if (!item)
            throw new NullPointerException("Cannot add a NULL value.");
        Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;
        if (size == 0) {
            // deck was empty
            last = first;
        }
        else {
            // deck was not empty
            oldfirst.prev = first;
        }
        size++;
    }

    public void addLast(Item item) {
        /* API: Insert the item to the rear of the deck */
        if (!item)
            throw new NullPointerException("Cannot add a NULL value.");
        Node oldlast = last;
        last = new Node(item);
        last.prev = oldlast;
        if (isEmpty())  first = last;
        else    oldlast.next = last;
        size++;
    }

    public Item removeFirst() {
        /* API: Remove an item from the front of the deck */
        if (isEmpty())
            throw new NoSuchElementException("Cannot delete from an empty Deck.");
        Item item = first.item;
        first = first.next;
        if (isEmpty())  last = first;
        else    first.prev = null;
        size--;
        return item;
    }

    public Item removeLast() {
        /* API: Remove an item from the rear of the deck */
        if (isEmpty())
            throw new NoSuchElementException("Cannot delete from an empty Deck.");
        Item item = last.item;
        last = last.prev;
        size--;
        if (size == 0)
            first = last;
        else
            last.next = null;
        return item;
    }


    /* Iteration support */
    public Iterator<Item> iterator() { return new DeckIterator(); }

    private class DeckIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException("No more elements to iterate upon.");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            // Not supported 
            throw new UnsupportedOperationException("remove() not supported within Iterators.");
        }
    }
}

import java.util.Random;
import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    /* A randomly chosen element is deleted from the data structure when required */

    private Item[] s;
    private int N;
    private Random rand;

    public RandomizedQueue() {
        /* Constructor: Initialise data structure */
        this.s = (Item[]) new Object[1];
        this.N = 0;
        this.rand = new Random();
    }

    public boolean isEmpty() {
        /* API: Check if queue is empty? */
        return N == 0;
    }

    public void enqueue(Item item) {
        /* API: Add an item to the randomized queue */
        // add to end of queue
        if (item == null)
            throw new NullPointerException("Cannot add NULL values.");
        if (N == s.length)  resize(N*2);
        s[N++] = item;
    }

    private void resize(int capacity) {
        /* Helper: Resize the array for adjusting more/less elements */
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public Item dequeu() {
        /* API: Delete and return a random element */
        if (isEmpty())
            return NoSuchElementException("Cannot delete from an empty randomized queue.");
        int index = rand.nextInt(N);
        Item item = s[index];
        // exchange this spot with last element
        exch(index, --N);
        // resize
        if (N == s.length / 4)  resize(s.length / 2);
        return item;
    }

    public Item sample() {
        /* API: Return (but do not delete) a randomly chosen element */
        int index = rand.nextInt(N);
        return s[index];
    }

    public int size() {
        /* API: return the number of items in the queue */
        return N;
    }

    /* Iteration functionality */
    public Iterator<Item> iterator() { 
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current = N-1;

        public boolean hasNext() {
            return current >= 0;
        }

        public void remove() {
            // not implemented
            throw new UnsupportedOperationException("remove() not supported within an iterator.");
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements to iterate upon.");
            return s[current--];
        }
    }
}

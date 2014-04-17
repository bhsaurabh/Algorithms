import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    /** Resizing Array implementation of a stack 
      */

    private Item[] s;
    private int N;

    public Stack() {
        /** Constructor: Initialise data members
         */
        this.s = (Item[]) new Object[1];
        this.N = 0;
    }

    public boolean isEmpty() {
        /** Check if the stack is empty
         *
         * Args:
         *   None
         * Returns:
         *   true if the stack is empty, false otherwise
         */
        return N == 0;
    }

    public void push(Item item) {
        /** Push an item onto the stack
         *
         * Args:
         *   item: The item to be pushed
         *
         * Returns:
         *   None
         */
        if (N == s.length) {
            resize(N*2);    // resize array if full
        }
        s[N++] = item;
    }

    public Item pop() {
        /** Removes an element from the top of the stack
         *
         * Args:
         *   None
         * Returns:
         *   item: The item that was popped
         */
        Item item = s[--N];
        s[N] = null;    // prevent loitering
        if (N == s.length / 4) {
            resize(s.length / 2);   // reduce array size to fit
        }
        return item;
    }

    private void resize(int capacity) {
        /** Helper method to resize the stack array
         *
         * Args:
         *   capacity: Integer value, the new capacity of the stack
         * Returns:
         *   None
         */
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public int size() {
        /** Return the size of the stack
         *
         * Args:
         *   None
         *
         * Returns:
         *   An integer that equals the number of elements in the stack
         */
        return N;
    }
    
    public Iterator<Item> iterator() {
        /** Return an iterator for the stack
         *
         * Args: None
         *
         * Returns: An Iterator to iterate over the stack
         */
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        /** Iterator class */

        private int current = N-1;

        public boolean hasNext() {
            /** Check if there are any more elements to iterate upon
             *
             * Args: None
             *
             * Returns: true, if further iteration is possible
             */
            return N >= 0;
        }

        public void remove() {
            /** Unsupported operation
             */
            throw new UnsupportedOperationException("remove() not supported within iterators.");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements to iterate upon.");
            }
            return s[current--];
        }
    }
    
}

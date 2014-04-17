import java.util.NoSuchElementException;

public class QueueWithStack<Item> {
    /** A queue implementation using 2 stacks 
     */
    private Stack<Item> s1, s2;

    public QueueWithStack() {
        /** Constructor: Initialise stacks to be used
         *
         * Args:
         *    None
         * Returns:
         *    None
         */
        this.s1 = (Stack<Item>)new Stack<Object>();
        this.s2 = (Stack<Item>)new Stack<Object>();
    }

    public void enqueu(Item item) {
        /** Enqueue an element into the queue
         *
         * Args:
         *   item: An Item to be added to the queue
         * Returns:
         *   None
         */
        s1.push(item);
    }

    public Item dequeue() {
        /** Dequeue an element
         *
         * Args:
         *   None
         * Returns:
         *   The item which is removed from the queue
         */
        if (isEmpty())
            throw new NoSuchElementException("Cannot delete from an empty queue.");
        if (s2.isEmpty()) {
            // copy all elements from s1 into s2
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        /** Check if the queue is empty
         *
         * Args:
         *   None
         * Returns:
         *   true if the queue is empty, false otherwise
         */
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        /** Return the size of the queue
         *
         * Args:
         *   None
         *
         * Returns:
         *   The number of elements in the queue
         */
        return s1.size() + s2.size();
    }
}

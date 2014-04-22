import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] pq;   // stores items at indices 1 to N
    private int N;      // number of items on the PQ

    /**
     * Initialise the empty priority queue with the provided capacity
     * @param capacity: the initial capacity of the priority queue
     */
    public MinPQ(int capacity) {
        this.pq = (Key[]) new Object[capacity+1];
        this.N = 0;
    }

    /**
     * Initialise an empty priority queue
     */
    public MinPQ() {
        this(1);
    }

    /**
     * Is the priority queue empty?
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of keys on the priority queue
     * @return the number of keys on the priority queue
     */
    public int size() {
        return N;
    }

    /**
     * Returns the smallest key in the priority queue
     * @return the smallest key in the priority queue
     * @throws java.util.NoSuchElementException if priority queue is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue Underflow");
        }
        return pq[1];
    }

    // helper function to resize the priority queue array
    private void resize(int capacity) {
        assert capacity > N;
        Key[] copy = (Key[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    /** Adds a new Key to the Priority Queue
     * @param x the key to be added to the priority queue
     */
    public void insert(Key x) {
        // double the size of the array if required
        if (N == pq.length) {
            resize(N*2);
        }

        // add to end and swim up to correct position
        pq[++N] = x;
        swim(N);
        assert isMinHeap();
    }

    /** Removes and returns the minimum Key on the Priority Queue
     * @return the minimum Key, which has been removed from the prioriy queue
     * @throws java.util.NoSuchElementException if Priority Queue is empty
     */
    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue underflow");
        }
        exch(1, N);
        Key min = pq[N--];
        pq[N+1] = null;  // avoid loitering
        sink(1);
        if ((N > 0) && (N < (pq.length-1)/4)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }

    /*******************************************************
     * Helpers to maintain heap invariants
     ******************************************************/
    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (less(j+1, j))   j++;
            if (!less(j, k))    break;
            exch(k, j);
            k = j;
        }
    }

    /*******************************************************
     * Helpers to swap and compare 
     ******************************************************/
    private void exch(int i, int j) {
        Key copy = pq[i];
        pq[i] = pq[j];
        pq[j] = copy;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // is pq[1..N] a min-heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    
    // is pq rooted at k a min-heap? 
    private boolean isMinHeap(int k) {
        if (k > N)  return true;
        int left = 2*k, right = left+1;
        if (left <= N && less(left, k)) return false;
        if (right <= N && less(right, k))   return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}

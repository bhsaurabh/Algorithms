public class UnorderedMaxPQ<Key extends Comparable<Key>> extends SortingHelpers
{
    // An array implementation of Max Priority Queues
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ()
    {
    	// generic array creation is not allowed
    	this.pq = (Key[]) new Comparable[1];
    	this.N = 0;
    }

    public void insert(Key x)
    {
    	// add to the array
    	if (N == pq.length)	resize(N*2);
    	pq[N++] = x;
    }

    private void resize(int capacity)
    {
    	Key[] copy = (Key[]) new Comparable[capacity];
    	for (int i = 0; i < N; i++)
    		copy[i] = pq[i];
    	pq = copy;
    }

    public boolean isEmpty()
    {
    	return N == 0;
    }

    public Key delMax()
    {
    	// search for maximum element
    	int max = 0;
    	for (int i = 0; i < N; i++)
    		if (less(pq[max], pq[i]))	max = i;
    	// swap the max element with last element
    	exch(pq, max, N-1);

    	Key item = pq[--N];
    	if (N == pq.length/4)	resize(pq.length/2);
    	return item;
    }
}
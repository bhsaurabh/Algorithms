import java.util.Random;
public class RandomizedQueue<Item> {
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

    public void enqueue(Item item) {
        /* API: Add an item to the randomized queue */
        // add to end of queue
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
        int index = rand.nextInt(N);
        Item item = s[index];
        // exchange this spot with last element
        exch(index, --N);
        // resize
        if (N == s.length / 4)  resize(s.length / 2);
        return item;
    }
}

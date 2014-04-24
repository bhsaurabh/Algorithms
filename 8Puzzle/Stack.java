import java.lang.Iterable;
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>
{
    // get an iterator
    public Iterator<Item> iterator() { return new ReverseArrayIterator(); }
    
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int current = N-1;
        public boolean hasNext()
        {
            return current >= 0;
        }
        
        public void remove()
        {
            // not implemented
        }
        
        public Item next()
        {
            Item item = s[current--];
            return item;
        }
    }



    private Item[] s;
    private int N;
    
    public Stack()
    {
        this.s = (Item[])new Object[1];
        this.N = 0;
    }
    
    private void resize(int capacity)
    {
        // O(N)
        Item[] copy = (Item[])new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }
    
    public void push(Item item)
    {
        // O(1)
        if (N == s.length)  resize(N*2);
        s[N++] = item;
    }
    
    public Item pop()
    {
        // O(1)
        Item item = s[--N];
        s[N] = null;
        if (N == s.length/4)    resize(s.length/2);
        return item;
    }

    public int size() {
        return N;
    }
}

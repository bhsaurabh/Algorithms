import java.util.Iterator;
import java.lang.Iterable;

public class QueueLL<Item> implements Iterable<Item>
{
    public Iterator<Item> iterator() { return new QueueLLIterator(); }
    
    private class QueueLLIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
        public void remove()
        {
            // not implemented
        }
    }
    
    private class Node
    {
        Item item;
        Node next;
        public Node(Item item)
        {
            this.item = item;
        }
    }
    
    private Node first, last;
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node(item);
        if (isEmpty())  first = last;
        else    oldlast.next = last;
    }
    
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty())  last = first;
        return item;
    }
}
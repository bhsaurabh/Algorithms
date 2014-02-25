import java.util.Iterator;
import java.lang.Iterable;
public class StackLL<Item> implements Iterable<Item>
{
    // get an iterator
    public Iterator<Item> iterator() { return new ListIterator(); }
    
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public void remove()
        {
            // not supported
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
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
    
    Node first;
    
    public void push(Item item)
    {
        // O(1)
        Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;
    }
    
    public Item pop()
    {
        // O(1)
        Item item = first.item;
        first = first.next;
        return item;
    }
}
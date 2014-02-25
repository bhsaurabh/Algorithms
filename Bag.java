import java.util.Iterator;
import java.lang.Iterable;

public class Bag<Item> extends Stack<Item>
{
    public Bag()
    {
        super();
    }
    
    public void add(Item item)
    {
        super.push(item);
    }
    
    // Override
    public Item pop()
    {
        // not implemented
        return null;
    }
}
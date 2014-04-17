public class StackWithMaxMin<Item extends Comparable<Item>> {
    /** Stack that can return the maximum and minimum of the elements stored in it */
    
    // Maintain 3 stacks - hold items, maximum and minimum
    private Stack<Item> s, max, min;

    public StackWithMaxMin() {
        /** Constructor: Initialise all data members
         *
         * Args: None
         *
         * Returns: None
         */
        this.s = new Stack<Item>();
        this.max = new Stack<Item>();
        this.min = new Stack<Item>();
    }

    public void push(Item item) {
        /** Push an item onto the stack
         *
         * Args:
         *   item: The item to be pushed onto the stack
         *
         * Returns:
         *   None
         */
        s.push(item);

        // push onto max stack if more than or equal to previous max
        if (!less(item, max.peek())) {
            max.push(item);
        }

        // push onto min stack if less than or equal to previous min
        if (!less(min.peek(), item)) {
            min.push(item);
        }
    }

    public Item pop() {
        /** Pops an element from the top of the stack
         *
         * Args:
         *   None
         *
         * Returns:
         *   Item:  Item at the top of the stack is deleted and returned
         */
        Item item = s.pop();
        
        // pop from max and min stacks if needed
        if (item == max.peek())
            max.pop();
        if (item == min.peek())
            min.pop();
        return item;
    }

    public Item max() {
        /** Return the max element in the stack
         *
         * Args:
         *   None
         *
         * Returns:
         *   Item: the maximum item in the stack is returned (but not deleted)
         */
        return max.peek();
    }
    
    public Item min() {
        /** Return the min element in the stack
         *
         * Args:
         *   None
         *
         * Returns:
         *   Item: the minimum item in the stack is returned (but not deleted)
         */
        return min.peek();
    }

    private boolean less(Comparable p, Comparable q) {
        /** Returns true if p is less than q
         *
         * Args:
         *   p, q: Comparables to be compared
         *
         * Returns:
         *   true if p is less than q, false otherwise
         */
        return p.compareTo(q) < 0;
    }
}

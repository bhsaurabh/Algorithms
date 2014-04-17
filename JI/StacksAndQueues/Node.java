public class Node<Item> {
    /** A Node class for use in linked lists */
    private Item item;
    public Node next;

    public Node(Item item) {
        /** Constructor
         *
         * Args: 
         *   Item item: The value to be stored in the node
         * 
         * Returns:
         *   None
         */
        this.item = item;
        this.next = null;
    }
    
    public Node(Item item, Node next) {
        /** Constructor
         *
         * Args: 
         *   Item item: The value to be stored in the node
         *   Node next: The node to point to
         *
         * Returns:
         *   None
         */
        this.item = item;
        this.next = next;
    }

    public Item getItem() {
        /** Get the item stored in the node
         *
         * Args: None
         *
         * Returns:
         *   The item that is stored in this Node
         */
        return this.item;
    }

    public void setItem(Item item) {
        /** Change/Set the item stored in the node
         *
         * Args:
         *   Item item: The item to be stored in the Node
         *
         * Returns:
         *   None
         */
        this.item = item;
    }


}

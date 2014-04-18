public class CloneLL {
    /** Clones a Linked List with Nodes that point to the next node and to a random node
     * Takes linear time
     */

    public static Node copy(Node head) {
        /** Clone the Linked List
         *
         * Args: 
         *   head: A pointer to the first node in the linked list
         *
         * Returns:
         *   Node newList: A pointer to the newly cloned list
         */

        // Create a copy of every node just after them
        Node x = head;
        while (x != null) {
            Node newNode = new Node();
            newNode.item = x.item;
            newNode.next = x.next;
            newNode.random = x.random;
            x.next = newNode;
            x = x.next.next;
        }

        // create correct links, currently we have new LL having pointers to nodes in old LL
        Node newList = head.next, y = newList;
        x = head;
        while (x != null) {
            x.next = x.next.next;
            y.next = y.next.next;
            y.random = y.random.next;
            x = x.next;
            y = y.next;
        }

        return newList;
    }
}

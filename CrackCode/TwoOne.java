public class TwoOne {
    /**
     * Remove duplicated from an unsorted LL
     *
     * @param head is the 1st node of the Linked List
     */
    public static void removeDuplicates(Node head) {
        // keep track of nodes using a Hash Table
        Hashtable table = new Hashtable();
        Node previous = null, n = head;

        while (n != null) {
            if (table.containsKey(n.key)) {
                // already seen, remove this
                previous.next = n.next;
            }
            else {
                table.put(n.key, true);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * Removes duplicates from a Linked List
     * but does not use any extra buffer space
     *
     * @param head is the 1st node of the Linked List
     */
    public static void deleteDuplicates(Node first) {
        if (head == null) {
            // nothing to do
            return;
        }

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.key == current.key) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}

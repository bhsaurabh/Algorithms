public class TwoThree {
    /**
     * Deletes a node given access to only that node
     *
     * @param node is the Node to be deleted
     *
     * @return true if deletion was successful, false otherwise
     */
    public static boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        // else copy over the next node
        Node next = node.next;
        node.item = next.item;
        node.next = next.next;
        return true;
    }
}

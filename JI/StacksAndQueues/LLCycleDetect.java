public class LLCycleDetect {
    /** Detects the presence of a cycle in a singly linked list */

    public static boolean hasCycle(Node first) {
        /** Checks if a singly linked list has a cycle or not
         *
         * Args:
         *   Node first: a pointer to the first Node of the Linked List
         *
         * Returns:
         *   true, if there exists a cycle, false otherwise
         */
        Node loop_start = getCycle(first);
        if (loop_start != null) {
            return true;
        }
        return false;
    }

    public static Node getCycle(Node first) {
        /** Checks if a LL has a cycle and returns a pointer to the first node in the cycle
         *
         * Args:
         *   Node first: A pointer to the first node in the LL
         *
         * Returns:
         *   null: if no cycle
         *   else, returns first node in cycle
         */
        Node fast, slow;
        fast = first;
        slow = first;

        // check if there exists a cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;  // collision of pointers, possible cycle
            }
        }

        if (fast == null || fast.next == null) {
            return null;    // reached end of LL => No cycle exists
        }

        /* Move slow to head, keep fast at meeting point
         * Both are equidistant from the loop start
         * When they meet again, they would meet at loop start
         */
        slow = first;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        // Both pointers now point to the loop's start
        return fast;
    }
}

public class FourOne {
    /** Check if a binary tree is balanced
     *
     * @param root is the root of the tree
     *
     * @return true if tree is balanced, false otherwise
     */
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;    // a null tree is considered balanced
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            // tree is not balanced
            return false;
        } else {
            // recurse and check if the sub trees are balanced
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * Get the height of the tree rooted at root
     *
     * @param root is the root of the tree in question
     *
     * @return the height of the tree
     */
    private int getHeight(Node root) {
        if (root == null) {
            return 0;   // base case
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

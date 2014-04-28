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
    private static int getHeight(Node root) {
        if (root == null) {
            return 0;   // base case
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * Finds height of the node. This is an optimised version of the code.
     *
     * @param root is the root of the tree in question
     *
     * @return the height of the tree rooted at root
     * Returns -1 if the tree is not balanced at root
     */
    private static int checkHeight(Node root) {
        if (root == null) {
            return 0;   // base case
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            // not balanced at root.left
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            // not balanced at root.right
            return -1;
        }

        /* Check if the current node is balanced */
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            // current node is not balanced
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /** 
     * Optimised check if tree is balanced of not
     *
     * @param root is the root of the tree
     *
     * @return true if balanced, false otherwise
     */
    public static boolean isBalanced2(Node root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
}

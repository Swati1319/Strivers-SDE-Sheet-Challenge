public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {

        // Base Cases.
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        // Calculate the difference between the root and its children.
        int differnce = root.data
                - ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0));

        /*
         * If the differnce is positive, increment either left or right child node.
         */
        if (differnce > 0) {
            if (root.left != null) {
                root.left.data += differnce;
            }

            else {
                root.right.data += differnce;
            }

        }

        // Call this function again for the left and right subtree.
        changeTree(root.left);
        changeTree(root.right);

        // Update root with the sum of the left and right child's data.
        root.data = ((root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0));
    }

}

import java.util.Stack;

public class Solution {

    static class BSTIterator {

        // Create a stack which will store smallest element at the top
        Stack<TreeNode<Integer>> st;

        public BSTIterator(TreeNode<Integer> root) {
            st = new Stack<>();
            
            // Fill the stack with leftmost nodes present in the subtree of root
            leftMostInorder(root);
        }

        public int next() {
            
            // Pop the minimum
            TreeNode<Integer> top = st.pop();
            
            // Check if it has right child
            if (top.right != null) {
            
                // Push leftmost nodes present in the subtree of right child
                leftMostInorder(top.right);
            }
            return top.data;
        }

        public boolean hasNext() {
            
            // If size of stack is greater than zero that means there are still some nodes left for processing
            if (st.size() > 0) {
                return true;
            }
            else {
                return false;
            }
        }

        // This function will used to push leftmost nodes in the stack present in the subtree of root
        private void leftMostInorder(TreeNode<Integer> root) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }
    }
}

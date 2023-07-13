import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    
    private static BinaryTreeNode<Integer> prev;

    private static boolean helper(BinaryTreeNode<Integer> root) {
        // Traverse the tree in inorder fashion
        // Keep track of previous node
        if (root != null) {
            if (!helper(root.left)) {  // Check left subtree
                return false;
            }

            if (prev != null && root.data < prev.data)  // Traversal not in ascending order.
            {
                return false;
            }

            prev = root;

            return helper(root.right);  // Check right subtree
        }

        return true;
    }

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        prev = null;
        return (helper(root));
    }
}

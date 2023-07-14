import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/


public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {

        // Base condition
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // If root.data is equal to 'X'
        if (root.data == X) {
            return root.data;
        }

        // If root -> data is greater than the 'X'
        if (root.data > X) {
            return floorInBST(root.left, X);
        }

        // Else, the floor may lie in right subtree or may be equal to the root
        int floorValue = floorInBST(root.right, X);

        return (floorValue <= X) ? floorValue : root.data;
    }
}

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

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Initializing ceil value
        int ceil = -1;

        // Traverse till the node is not null
        while (node != null) {

            // If node value equals key then return it
            if (x == node.data) {
                return node.data;
            }

            // Traverse right sub-tree
            if (x > node.data) {

                node = node.right;
            }

            // Traverse left sub-tree
            else {
                ceil = node.data;
                node = node.left;
            }
        }

        // Return the ceil value
        return ceil;

    }
}

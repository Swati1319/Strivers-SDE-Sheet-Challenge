import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    // NodeData struct to store root node of subtree and their respective range in given array.
    public static class nodeData
    {
        TreeNode<Integer> node;

        // Low and high are left and right range for given 'arr'.
        int low, high;

        nodeData(TreeNode<Integer> root, int left, int right)
        {
            node = root;
            low = left ;
            high = right;
        }
    }

    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        /*
            Initialise a root node with 'val' = -1 and range [ 0:n-1 ] and push it into a stack data structure.
            Later on we will update its 'val' to arr['mid'], where 'mid' is middle index of range [0:n-1].
        */
        TreeNode<Integer> root = new TreeNode<Integer> (-1);
        Stack<nodeData> st = new Stack<nodeData>();

        nodeData node = new nodeData(root, 0, n - 1);
        st.push(node); 

        while (st.empty() == false)
        {
            nodeData curNode = st.peek();
            st.pop();

            // Find 'mid' for the currNode and update node with arr[mid].
            int mid = curNode.low + (curNode.high - curNode.low) / 2;
            curNode.node.val = arr.get(mid);

            // Push the left part of array, that makes left subtree of current node.
            if (curNode.low < mid)
            {
                curNode.node.left = new TreeNode<Integer>(-1);

                node = new nodeData(curNode.node.left, curNode.low, mid - 1);
                st.push(node);
            }

            // Push the right part of array, that makes right subtree of current node.
            if (curNode.high > mid) 
            {
                curNode.node.right = new TreeNode<Integer>(-1);
                
                node = new nodeData(curNode.node.right, mid+1, curNode.high);
                st.push(node);
            }
        }

        // Return root of tree.
        return root;
    }
}

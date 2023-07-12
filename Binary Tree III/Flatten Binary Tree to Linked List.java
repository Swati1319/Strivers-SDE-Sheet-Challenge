
public class Solution 
{
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        TreeNode<Integer> currentNode = root;

        while (currentNode != null)
        {
            if (currentNode.left != null)
            {
                // Place the right subtree at its correct position (according to the linked list).
                // To do this, find the rightmost node present in the left subtree.
                TreeNode<Integer> predecessor = currentNode.left;
    
                while (predecessor.right != null)
                {
                    predecessor = predecessor.right;
                }
    
                // Make the right subtree of the current node as right child of "predecessor".
                predecessor.right = currentNode.right;
    
                // Make the left subtree of the current node as the new right subtree.
                currentNode.right = currentNode.left;
    
                currentNode.left = null;
            }
    
            // Set the right child of the node as the current node.
            currentNode = currentNode.right;
        }
    
        return root;    
    }
}

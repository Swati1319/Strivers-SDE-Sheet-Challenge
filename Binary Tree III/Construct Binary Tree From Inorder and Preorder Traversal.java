import java.util.ArrayList;
import java.util.HashMap;

public class Solution 
{

    // Constructs the subtree and returns the root node.
    private static TreeNode<Integer> constructTree(int inStart, int inEnd, int [] pIndex, HashMap<Integer, Integer>  inorderIndex, ArrayList<Integer> preorder) 
    {
        if (inStart > inEnd) 
        {

            // Subtree is empty.
            return null;
        }

        // Get root node value from preorder sequence.
        int rootNode = preorder.get(pIndex[0]);

        // Increment the index denoting the first element of preorder traversal.
        pIndex[0] = pIndex[0] + 1;

        // Create the root node with "rootNode" value.
        TreeNode<Integer> root = new TreeNode<Integer>(rootNode);

        if (inStart == inEnd) 
        {

            // There is a single node in the given subtree.
            return root;
        } 
        else 
        {

            // Get the index of root node value using the HashMap.
            int inIndex = inorderIndex.get(root.data);

            // Recur for the left subtree.
            TreeNode<Integer> leftChild = constructTree(inStart, inIndex - 1, pIndex, inorderIndex, preorder);

            // Recur for the right subtree.
            TreeNode<Integer> rightChild = constructTree(inIndex + 1, inEnd, pIndex, inorderIndex, preorder);

            // Link the left and right child to the root node.
            root.left = leftChild;
            root.right = rightChild;

            return root;
        }
    }

    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        
        // A HashMap to store the <nodeValue, index> pair of inorder sequence.
        HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.size(); i++) 
        {

            // Storing key, value pair
            inorderIndex.put(inorder.get(i), i);
        }

        // Index of the first element of the preorder sequence
        int []pIndex = {0};

        return constructTree(0, inorder.size() - 1, pIndex, inorderIndex, preorder);
    }
}

import java.util.Queue;
import java.util.LinkedList;

public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root) 
    {

        //    Intialize serialized as an empty string
        StringBuilder serialized = new StringBuilder();

        //    Queue for level order traversal
        Queue<TreeNode<Integer> > level = new LinkedList<TreeNode<Integer>>();
        
        if(root == null)
        {
            serialized.append("-1");
        }
        else
        {
            level.add(root);
        }

        while (level.isEmpty() == false) 
        {
            
            //    Pop the Node at the front
            TreeNode<Integer> curr = level.remove();

            //    If the current node is not null.
            if (curr != null) 
            {
                
                //    Add the value of the curr node to the serialized string.
                serialized.append(String.valueOf(curr.data));
                serialized.append(",");

                //    Push the left and the right child nodes in the queue.
                level.add(curr.left);
                level.add(curr.right);
            }

            //    If the current node is null
            else 
            {
                
                //    Add -1 to the serialized string.
                serialized.append("-1,");
            }
        }

        //    Return the serialized binary tree.
        return serialized.toString();
    }

    public static TreeNode<Integer> deserializeTree(String serialized) 
    {

        //    Pointer for reading elements from the serialized binary tree.
        int ptr = 0;
        StringBuilder firstVal = new StringBuilder();

        //    Read the first value from the string.
        while (ptr < serialized.length() && serialized.charAt(ptr) != ',') 
        {

            firstVal.append(serialized.charAt(ptr));
            ptr++;
        }
        ptr++;

        int data = Integer.valueOf(firstVal.toString());

        //    If the first value if -1 then return null.
        if (data == -1) 
        {
            return null;
        }

        //    Create a new root node.
        TreeNode<Integer> root = new TreeNode<Integer>(data);

        //    Queue for level order traversal.
        Queue<TreeNode<Integer>> level = new LinkedList<TreeNode<Integer>>();

        //    Push the root node into the queue.
        level.add(root);

        while (level.isEmpty() == false) 
        {
            
            //    Pop the front node from the queue.
            TreeNode<Integer> curr = level.remove();

            StringBuilder leftChild = new StringBuilder();

            //    Read the value of the left child.
            while (ptr < serialized.length() && serialized.charAt(ptr) != ',') 
            {
                leftChild.append(serialized.charAt(ptr));
                ptr++;
            }
            ptr++;
            StringBuilder rightChild = new StringBuilder();

            //    Read the value of the right child.
            while (ptr < serialized.length() && serialized.charAt(ptr) != ',') 
            {
                rightChild.append(serialized.charAt(ptr));
                ptr++;
            }
            ptr++;

            int leftChildValue = Integer.valueOf(leftChild.toString());
            int rightChildValue = Integer.valueOf(rightChild.toString());

            //    If the left child node is not null
            if (leftChildValue != -1) 
            {
                
                //    Create new left child node.
                TreeNode<Integer> leftNode = new TreeNode<Integer>(leftChildValue);
                curr.left = leftNode;

                //    Push the left child into the queue.
                level.add(curr.left);
            }

            //    If the right child is not null
            if (rightChildValue != -1) 
            {
                
                //    Create new right child node.
                TreeNode<Integer> rightNode = new TreeNode<Integer>(rightChildValue);
                curr.right = rightNode;

                //    Push the right child into the queue.
                level.add(curr.right);
            }
        }

        //    Return the root of deserialized the binary tree.
        return root;
    }
}

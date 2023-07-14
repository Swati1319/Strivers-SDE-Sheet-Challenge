import java.util.* ;
import java.io.*; 
/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/
public class Solution {
	public static class info 
	{
		boolean isValid;
		int size, min, max;
        info(boolean isValid, int size, int min, int max){
            this.isValid = isValid;
            this.size = size;
            this.min = min;
            this.max = max;
        }
	};

	public static info maxSize(TreeNode < Integer > currNode, int maxBST[])
	{
		if (currNode == null)
		{
			// isValid, size, min, max.
            info tmp = new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
           	return tmp;
		}

		// Information of left and right subtrees.
		info left = maxSize(currNode.left, maxBST);
		info right = maxSize(currNode.right, maxBST);

		info currInfo = new info(true, 0, 0, 0);

		// Size of current subtree.
		currInfo.size = left.size + right.size + 1;
		
		// Left and Right subtrees must be BST.
		currInfo.isValid = ( left.isValid & right.isValid );
		
		// Current subtree must form a BST.
		currInfo.isValid &= (currNode.data > left.max);
		currInfo.isValid &= (currNode.data < right.min);
		
		// Updating min and max for current subtree.
		currInfo.min = Math.min(Math.min(left.min, right.min), currNode.data);
		currInfo.max = Math.max(Math.max(left.max, right.max), currNode.data);

		if (currInfo.isValid == true)
		{
			maxBST[0] = Math.max(maxBST[0], currInfo.size);
		}

		return currInfo;
	}

	public static int largestBST(TreeNode<Integer> root) {
		int[] maxBST = new int[2];

		maxSize(root, maxBST);

		return maxBST[0];
	}
}

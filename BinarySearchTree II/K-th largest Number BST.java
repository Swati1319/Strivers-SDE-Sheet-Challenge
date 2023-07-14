import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

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

*************************************************************/
   
import java.util.ArrayList;

public class Solution {
	public static int revInorder(TreeNode < Integer > root, int [] visCount, int k)
	{
		if (root == null)
		{
			return -1;
		}
		
		// Recurse over right subtree. 
		int right = revInorder(root.right, visCount, k);
	    
	    if (right != -1)
	    {
	    	return right;
	    }

		visCount[0]++;

		if (visCount[0] == k)
		{
			return root.data;
		}

		// Recurse over left subtree.
		int left = revInorder(root.left, visCount, k);
	    
	    return left;
	}


	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		int[] visCount = new int [1];

		return revInorder(root, visCount, k);
	}
}

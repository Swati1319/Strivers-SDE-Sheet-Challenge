import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Tree node structure

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
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		int predecessor = -1;
	    int successor = -1;

	    // Reach to the key.
	    while (root.data != key)
	    {
	        if (key > root.data)
	        {
	            predecessor = root.data;
	            root = root.right;
	        }
	        else
	        {
	            successor = root.data;
	            root = root.left;
	        }
	    }

	    
	    BinaryTreeNode < Integer > rightSubtree = root.right;

	    while (rightSubtree != null)
	    {
	        successor = rightSubtree.data;
	        rightSubtree = rightSubtree.left;
	    }


	    BinaryTreeNode < Integer > leftSubtree = root.left;

	    while (leftSubtree != null)
	    {
	        predecessor = leftSubtree.data;
	        leftSubtree = leftSubtree.right;
	    }

	    ArrayList < Integer > sol = new ArrayList < Integer > ();
        sol.add(predecessor);
        sol.add(successor);
	    return sol;
	}
}

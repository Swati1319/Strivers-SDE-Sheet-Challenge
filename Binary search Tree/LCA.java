//LCA of Two Nodes In A BST

import java.util.* ;
import java.io.*; 
/*

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

*/

public class Solution 
{
	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
	{

		while (root != null) 
		{
			if ((root.data < p.data) && (root.data < q.data)) 
			{
				root = root.right;
			} 
			else if ((root.data > p.data) && (root.data > q.data)) 
			{
				root = root.left;
			} 
			else 
			{
				return root;
			}
		}
		
		return root;
	}
}

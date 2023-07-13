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
			left = right = null;
		}

};************************************************************/

public class Solution {

	static int preIndex;

	private static TreeNode<Integer> util(int[] preOrder, int startRange, int endRange) {

		// If the preIndex is greater than the length of the array return NULL.
		if (preIndex >= preOrder.length) {
			return null;
		}

		int currNode = preOrder[preIndex];

		// If the current node lies inside the range then process the node.
		if (currNode > startRange && currNode < endRange) {
			TreeNode<Integer> root = new TreeNode<>(currNode);

			// Increase the index by 1.
			preIndex += 1;

			// If left node exists process left.
			if (preIndex < preOrder.length) {
				root.left = util(preOrder, startRange, currNode);
			}
			// If right node exists process right.
			if (preIndex < preOrder.length) {
				root.right = util(preOrder, currNode, endRange);
			}

			// Return the root.
			return root;
		}

		// If node was not processed return NULL.
		return null;

	}

	public static TreeNode<Integer> preOrderTree(int[] preOrder) {

		preIndex = 0;

		// Return the util function.
		return util(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}


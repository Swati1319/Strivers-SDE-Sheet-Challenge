//Maximum Path Sum Between Two Leaves

class Number{
    long num;
    Number(long num)
    {
        this.num = num;
    }
}

public class Solution {
	public static long findMaxSumPathHelper(TreeNode root, Number maxPathSum) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		/* 
			Variable to store the maximum sum of the path from the current node to leaf
		 	in the left subtree.
		*/
		long maxSumLeftPath = findMaxSumPathHelper(root.left, maxPathSum);

		/*
			Variable to store the maximum sum of the path from the current node to leaf
		 	in the right subtree.
		*/
		long maxSumRightPath = findMaxSumPathHelper(root.right, maxPathSum);

		// If the current node has both children, update the value of maxPathSum.
		if (root.left != null && root.right != null) {

			maxPathSum.num = Math.max(maxPathSum.num, maxSumLeftPath + maxSumRightPath + root.data);
			return Math.max(maxSumLeftPath, maxSumRightPath) + root.data;

		} else if (root.left == null) {

			return maxSumRightPath + root.data;

		} else {

			return maxSumLeftPath + root.data;

		}
	}

	public static long findMaxSumPath(TreeNode root) {
		// Variable to store the maximum sum of path between two leaves for the given tree.
		Number maxPathSum = new Number(-1L);
		findMaxSumPathHelper(root, maxPathSum);
		return maxPathSum.num;
	}
}

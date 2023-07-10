/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where 'N' is the number of nodes in the given binary tree.
 */

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	public static int getMaxWidth(TreeNode root) {
		// Base case.
		if (root == null) {
			return 0;
		}

		// For level order traversal.
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		int maxWidth = 0;

		// Iterate over level by level.
		while (!q.isEmpty()) {
		
			// Get the width of current level.
			int currWidth = q.size();
		
			// Check, If the width of the current level is better than older?
			if (maxWidth < currWidth) {
				maxWidth = currWidth;
			}
		
			// Push all the children of the root node which are at the current level.
			while (currWidth > 0) {
				
				// Get the front of queue.
				TreeNode currNode = q.peek();
				q.poll();
				
				// Push left child of currNode if exist.
				if (currNode.left != null) {
					q.add(currNode.left);
				}
				
				// Push right child of currNode if exist.
				if (currNode.right != null) {
					q.add(currNode.right);
				}
				currWidth = currWidth - 1;
			}
		}

		return maxWidth;
	}
}

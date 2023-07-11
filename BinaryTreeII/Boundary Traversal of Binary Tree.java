
import java.util.ArrayList;

public class Solution {
	// Functions to traverse on each part.
	public static ArrayList<Integer> traverseBoundary(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		ans.add(root.data);

		// Traverse left boundary.
		leftBoundary(root.left, ans);

		// Traverse for leaf nodes.
		leafNodes(root.left, ans);
		leafNodes(root.right, ans);

		// Traverse right boundary.
		rightBoundary(root.right, ans);

		return ans;
	}

	public static void leftBoundary(TreeNode root, ArrayList<Integer> ans) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		ans.add(root.data);

		if (root.left != null) {
			leftBoundary(root.left, ans);
		} 
        
        else {
			leftBoundary(root.right, ans);
		}
	}

	public static void rightBoundary(TreeNode root, ArrayList<Integer> ans) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		if (root.right != null) {
			rightBoundary(root.right, ans);
		} 
        
        else {
			rightBoundary(root.left, ans);
		}

		ans.add(root.data);
	}

	public static void leafNodes(TreeNode root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			ans.add(root.data);
			return;
		}

		leafNodes(root.left, ans);
		leafNodes(root.right, ans);
	}
}

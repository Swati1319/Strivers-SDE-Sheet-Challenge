import java.util.Stack;

public class Solution {

	// Function which helps in filling the required path in the stack.
	private static boolean helper(TreeNode<Integer> root, Stack<TreeNode<Integer>> st, TreeNode<Integer> leaf) {
		// Push the current node i.e "root" into the stack.
		st.push(root);
	
		// Check if it is a leaf node of the given binary tree.
		if (root.left == null && root.right == null) {
			// Check if this leaf is the given leaf node then return true.
			if (root.data.intValue() == leaf.data.intValue()) {
				return true;
			}
			// Else, pop-out the current node from the stack and then return false.
			else {
				st.pop();
				return false;
			}
		}

		// Variables to store the result obtained from left and right subtree calls.
		boolean left = false, right = false;

		// Call for the left subtree, if there exists left child.
		if (root.left != null) {
			left = helper(root.left, st, leaf);
		}
		// If found the required path then return true.
		if (left) {
			return true;
		}

		// Call for the right subtree, if there exists right child.
		if (root.right != null) {
			right = helper(root.right, st, leaf);
		}
		// If found the required path then return true.
		if (right) {
			return true;
		}

		// Otherwise, pop-out the current node from the stack and then return false.
		st.pop();
		return false;
	}

	public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
		// If the root is null then return root itself.
		if (root == null) {
			return root;
		}

		// Stack that will store the path which includes the given leaf node.
		Stack<TreeNode<Integer>> st = new Stack<TreeNode<Integer>>();

		// Call the helper function.
		helper(root, st, leaf);
		// System.out.println(st.size());
		// Node that holds the new Root i.e. the given leaf node.

		
		TreeNode<Integer> newRoot = st.peek();
		st.pop();

		// Node that stores the parent of the current node while inverting the given
		// binary tree.
		TreeNode<Integer> parent = newRoot;

		while (!st.isEmpty()) {
			// Node that stores the current node.
			TreeNode<Integer> curNode = st.peek();
			st.pop();

			if (curNode.left == parent) {
				curNode.left = null;
				parent.left = curNode;
			} else {
				curNode.right = curNode.left;
				curNode.left = null;
				parent.left = curNode;
			}

			parent = parent.left;
		}

		return newRoot;
	}
}

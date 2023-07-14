import java.util.Stack;

public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {

		/*
	        Stack 'start' and 'end' to store the smaller and larger 
	        values of BST respectively.
    	*/
		Stack<BinaryTreeNode> start = new Stack<>();
		Stack<BinaryTreeNode> end = new Stack<>();

		BinaryTreeNode currNode = root;

		// Storing left values of BST in 'start'.
		while (currNode != null) {
			start.push(currNode);
			currNode = currNode . left;
		}

		// Setting currNode again pointing to root.
		currNode = root;

		// Storing right values of BST in 'end'.
		while (currNode != null) {
			end.push(currNode);
			currNode = currNode . right;
		}

		while (start.peek() != end.peek()) {

			// Storing top node's value of 'start' stack in 'val1'.
			int val1 = start.peek().data;

			// Storing top node's value of 'end' stack in 'val2'.
			int val2 = end.peek().data;

			// If sum of 'val1' and 'val2' is equal to 'k' then return "true".
			if (val1 + val2 == k) {
				return true;
			}

			// Move to the next greatest closer value.
			if (val1 + val2 < k) {
				currNode = start.peek().right;
				start.pop();

				while (currNode != null) {
					start.push(currNode);
					currNode = currNode.left;
				}
			}

			// Move to the next smallest closer value.
			else {
				currNode = end.peek().left;
				end.pop();

				while (currNode != null) {
					end.push(currNode);
					currNode = currNode.right;
				}
			}
		}

		// If no two nodes is found, return false.
		return false;
	}
}

/*
	Time complexity: O(N)
	Space complexity: O(N)

	Where 'N' denotes the number of nodes in the Binary tree.
*/

public class Solution 
{
	private static TreeNode<Integer> buildTreeHelper(int[] postOrder, int postStart, int postEnd, int[] inOrder,
														int inStart, int inEnd) 
    {	 													
		if (postStart > postEnd || inStart > inEnd) 
        {
			return null;
		}

        // Assign rootVal as postOrder[postEnd]
		int rootVal = postOrder[postEnd];
        
		TreeNode<Integer> root = new TreeNode<Integer>(rootVal);

		// Find parent element index from inOrder array.
		int k = 0;
		
        // Iterate i from inStart to inEnd
        for (int i = inStart; i <= inEnd; i++) 
        {
			if (rootVal == inOrder[i]) 
            {
				k = i;
				break;
			}
		}

        // Create recursive call for left and right subtree
		root.left = buildTreeHelper(postOrder, postStart, postStart + k - inStart - 1, inOrder, inStart, k - 1);
		root.right = buildTreeHelper(postOrder, postStart + k - inStart, postEnd - 1, inOrder, k + 1, inEnd);

		return root;
	}

	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) 
    {
		int n = postOrder.length;

		int postStart = 0;
		int postEnd = n - 1;
		int inStart = 0;
		int inEnd = n - 1;

        // Call buildTreeHelper function 
		return buildTreeHelper(postOrder, postStart, postEnd, inOrder, inStart, inEnd);
	}
}


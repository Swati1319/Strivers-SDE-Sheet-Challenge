import java.util.Stack;

public class Solution 
{

	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{

		Stack<TreeNode> stack = new Stack<>();

		while (true) 
		{

			while (root != null) 
			{
				stack.add(root);
				root = root.left;
			}

			root = stack.pop();

			if (k == 1) 
			{
				return root.data;
			}

			//	Update the 'k'
			k = k - 1;

			root = root.right;
		}

	}
}

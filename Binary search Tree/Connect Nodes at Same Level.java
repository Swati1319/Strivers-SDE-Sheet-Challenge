public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {

    	// Keep the address of the first node of the current level.
	    BinaryTreeNode<Integer> startNode = root;

	    while(startNode != null) {

	        BinaryTreeNode<Integer> ptr = startNode;
	        BinaryTreeNode<Integer> previous = null;
	        startNode = null;
	        
	        // Traversing over nodes of current level and populating 'next' pointer of nodes of next level.
	        while(ptr != null) {

	            if(ptr.left != null) {

	                if(previous != null) {
	                    previous.next = ptr.left;
	                }

	                // Update 'startNode' with first node of next level if not already done.
	                if(startNode == null) {
	                    startNode = ptr.left;
	                }

	                // Update previous pointer
	                previous = ptr.left;
	            }

	            if(ptr.right != null) {

	                if(previous != null) {
	                    previous.next = ptr.right;
	                }

	                // Update 'startNode' with first node of next level if not already done.
	                if(startNode == null) {
	                    startNode = ptr.right;
	                }

	                // Update previous pointer.
	                previous = ptr.right;
	            }

	            ptr = ptr.next;
	        }
	    }
	}
}

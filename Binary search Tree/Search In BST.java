

public class Solution {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        BinaryTreeNode<Integer> ptr = root;
    
        while(ptr != null) {
            if(ptr.data == x) {
                return true;
            } else if(ptr.data > x) {
                // Move 'ptr' to left child. 
                ptr = ptr.left;
            } else {
                // Move 'ptr' to left child. 
                ptr = ptr.right;   
            }
        }

        return false;
    }
}

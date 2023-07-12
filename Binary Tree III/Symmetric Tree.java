
public class Solution {

    private static boolean checkSymmetricity(BinaryTreeNode<Integer> firstRoot, BinaryTreeNode<Integer> secondRoot) {

        // Check if both nodes are null
        if(firstRoot == null && secondRoot == null) {
            return true;
        }

        // Check if one node is null, while the other is non-null
        if( (firstRoot == null && secondRoot != null) || (firstRoot != null && secondRoot == null) ) {
            return false;
        }

        // Check if the number present in the nodes are unequal
        if(!firstRoot.data.equals(secondRoot.data)) {
            return false;
        }

        // Finally, do the same for left node of firstRoot and right node of secondRoot, 
        // and right of firstRoot and left of secondRoot.
        return checkSymmetricity(firstRoot.right, secondRoot.left) && checkSymmetricity(firstRoot.left, secondRoot.right);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return checkSymmetricity(root, root); 
    }
}

public class Solution {       
    public static boolean identicalTrees(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if (p == null && q == null) {            
            return true;        
        }                
        if (p == null || q == null) {            
            return false;        
        }                
        return p.data.equals(q.data) && identicalTrees(p.left, q.left) && identicalTrees(p.right, q.right);    
    } 
}  

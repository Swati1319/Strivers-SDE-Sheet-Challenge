public class Solution 

{

    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 

    {

        if(root==null){

            return -1;

        }

        if(root.data==x || root.data==y){

            return root.data;

        }

        int leftLca=lowestCommonAncestor(root.left,x,y);

        int rightLca=lowestCommonAncestor(root.right,x,y);

        if(rightLca==-1){

            return leftLca;

        }

        if(leftLca==-1){

            return rightLca;

        }

        return root.data;

    }

}

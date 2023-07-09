import java.util.* ;

import java.io.*; 

/************************************************************

 

    Following is the TreeNode class structure

 

    class TreeNode<T> 

    {

       public:

        T data;

        TreeNode<T> left;

        TreeNode<T> right;

 

        TreeNode(T data) 

        {

            this.data = data;

            left = null;

            right = null;

        }

    };

 

************************************************************/

 

import java.util.ArrayList;

 

public class Solution 

{

   public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 

    {

        //    Write your code here.

        ArrayList<Integer> list = new ArrayList<>();

        makeList(root, 0,list);

        return list;

    }

    private static void makeList(TreeNode<Integer> root, int level, ArrayList<Integer> list){

        if(root==null){

            return;

        }

        //adding every level first element to the list

        if(list.size()==level){

            //the index acts as the level

            list.add(level,root.data);

        }

        makeList(root.left, level+1,list);

        makeList(root.right, level+1,list);

    }

}

import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {   
		ArrayList<Integer> ans = new ArrayList<>(); 
		if(root==null){  return ans; } 
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){ 
			BinaryTreeNode temp = q.poll();  
			ans.add(temp.val); 
			if(temp.left!=null){
				q.offer(temp.left);
			} 
			if(temp.right!=null){
				q.offer(temp.right);
			} 
		} 
		return ans;  
	}

}

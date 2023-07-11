public class Solution {    
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {        
		// zigzag traversal done using level order traversal        
		List<Integer> result = new ArrayList<Integer>();        
		if (root == null)            
		return result;        
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();        
		q.add(root);        
		boolean leftright = true;        
		while (q.size() > 0) {            
			int size = q.size();            
			List<Integer> ans = new ArrayList<>();                        
			for(int i=0; i<size; i++){                
				BinaryTreeNode<Integer> front = q.peek();                
				q.poll();                                
				if(front.left != null)                    
				q.add(front.left);                
				if(front.right != null)                    
				q.add(front.right);
				ans.add(front.data);            
			}            
			if(leftright == true){            

			}            
			else{                
				Collections.reverse(ans);            
				}            
				
			for(int i=0; i<ans.size(); i++){                
				result.add(ans.get(i));            
			}            
			leftright = !(leftright);       
			}        
			return result;    
		} 
   }

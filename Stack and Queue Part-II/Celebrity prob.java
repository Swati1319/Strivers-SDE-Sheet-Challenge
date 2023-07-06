import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution { 
	public static int findCelebrity(int n) {        
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;i++){  stack.push(i);  }
		while(stack.size()>1){   
			int a = stack.peek();   
			stack.pop();   
			int b = stack.peek();   
			stack.pop();
			if(Runner.knows(a,b)){    
				stack.push(b);   
			}   
			else{
				stack.push(a);   
			}  
		}
		int ans = stack.peek();  
		stack.pop();
		for(int i=0;i<n;i++){   
			if(i!=ans){    
				if(Runner.knows(ans,i)==true || Runner.knows(i,ans)==false){     
					return -1;    
				}   
			}  
		}  
		return ans;

   } 
}

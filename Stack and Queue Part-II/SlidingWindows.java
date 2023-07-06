import java.util.* ; 
import java.io.*;


public class Solution  {

public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k)  
{  //   Write your code here.        
	ArrayList<Integer> res = new ArrayList<>();                
	Deque<Integer> q = new ArrayDeque<>();        
	for(int i =0;i<nums.size();i++){            
		if(!q.isEmpty() && q.peek()==i-k) q.poll();            
		while(!q.isEmpty() && nums.get(q.peekLast())<nums.get(i)) q.pollLast();            
		q.offer(i);                        
		if(i>=k-1){                
			res.add(nums.get(q.peek()));            
		}                    
	}
	return res;                 
	} 
}

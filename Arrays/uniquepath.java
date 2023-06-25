import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		if(n==1 || m==1)return 1;
		int[] pre=new int[n];
		Arrays.fill(pre,1);
		
		for(int i=1;i<m;i++){
			int[] curr=new int[n];
			curr[0]=1;
			for(int j=1;j<n;j++){
                curr[j]=curr[j-1]+pre[j];
			}
			pre=curr;
		}
		return pre[n-1];
		
	}
	
}

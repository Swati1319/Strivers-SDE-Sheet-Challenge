import java.util.ArrayList;
public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
		int i=0,j=0;
		for( i=0;i<n;i++){
			if(arr.get(i)==0){
				k--;
			}
			if(k<0 && arr.get(j++)==0){
				k++;
			}
		}
		return i-j;
	}
}

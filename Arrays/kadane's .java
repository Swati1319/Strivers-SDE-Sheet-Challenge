import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long sum = 0;
		long maxi = Long.MIN_VALUE;

		for(int i = 0; i < n; i++){
			sum += arr[i];

			maxi = Math.max(maxi, sum);
			
			if(sum < 0) sum = 0;
		}

		if(maxi < 0) maxi = 0;

		return maxi;
	}

}

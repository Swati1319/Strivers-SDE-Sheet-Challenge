public class Solution 
{
	private static int lowerBound(int[] a, int low, int high, int element) 
	{
		while (low < high) 
		{
			int middle = low + (high - low) / 2;
			if (element > a[middle]) 
			{
				low = middle + 1;
			} else 
			{
				high = middle;
			}
		}

		return low;
	}
	public static int longestIncreasingSubsequence(int arr[]) 
	{
		int n = arr.length;

		// dp[i] represents i+1'th length LIS ending at minimum integer dp[i]
		int dp[] = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++) 
		{
			/*
			    Since dp array stores elements in the sorted order therefore
			    we can use binary search to find the correct position for
			    arr[i] to be placed.
			    And elements are present in the dp array from 0 to ans-1 position
			    So we will be doing the binary search in this range.
			*/
			int position = lowerBound(dp, 0, ans, arr[i]);
			dp[position] = arr[i];

			if (position == ans) 
			{
				ans++;
			}
		}

		return ans;
	}

}

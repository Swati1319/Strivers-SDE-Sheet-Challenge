public class Solution 
{
	public static long countWaysToMakeChange(int denominations[], int value)
    {	
		// Dp[i] will be storing the number of solutions for value i
		long dp[] = new long[value+1];
		dp[0] = 1;

		for (int i = 0; i < denominations.length; i++) 
        {
			for (int j = denominations[i]; j <= value; j++) 
            {
				dp[j] += dp[j - denominations[i]];
			}
		}

		return dp[value];
	}

}

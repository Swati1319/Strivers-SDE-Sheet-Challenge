public class Solution 
{
    public static int cutLogs(int k, int n) 
    {	
        // Create an array dp
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) 
        {
            dp[i] = i;
        }
		
        // Iterate i from 2 to K
        for (int i = 2; i <= k; i++) 
        {	
            // Create an array dp2
            int[] dp2 = new int[n + 1];
            int t = 1;
			
            // Iterate j from 1 to N
            for (int j = 1; j <= n; j++) 
            {
                while (t < j && Math.max(dp[t - 1], dp2[j - t]) > Math.max(dp[t], dp2[j - t - 1])) 
                {
                    t++;
                }

                dp2[j] = 1 + Math.max(dp[t - 1], dp2[j - t]);
            }
			
            // Update dp with dp2
            dp = dp2;
        }
        
		// Return the element dp[n]
        return dp[n];
    }
}

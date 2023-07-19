public class Solution {

    public static boolean subsetSumToK(int n, int k, int arr[]){
       
        // Declaring dp array.
        boolean dp[][] = new boolean[n + 1][k + 1];
    
        // If required sum = 0, answer always true.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
    
        // If size of array = 0, answer always false.
        for (int i = 1; i <= k; i++) {
            dp[0][i] = false;
        }
    
        // Filling dp array.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
    
        return dp[n][k];
    }
}

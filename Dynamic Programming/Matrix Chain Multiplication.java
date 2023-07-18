public class Solution {
	
	// Function to find minimum cost(scalar multiplication) of matrix multipication
	public static int matrixMultiplication(int[] arr, int N) {

	    /* 
	        For simplicity of the program, one
	        extra row and one extra column are allocated in 'dp[][]'.
	        0th row and 0th column of 'dp[][]'' are not used 
	    */

	    int dp[][] =new int[N][N];
	   
	    /* 
	        State: dp[i, j] = Minimum number of scalar
	        multiplications needed to compute the
	        matrix A[i]A[i+1]...A[j] = A[i..j] where
	        dimension of A[i] is arr[i-1] x arr[i] 
	    */

	    // The cost of multiplying one matrix is 0
	    for (int i = 1; i < N; i++)
	    {
	        // Make dp[i][i] 0
	        dp[i][i] = 0;
	    }
	       

	    // Run a loop from length 2 to n - 1 
	    for (int l = 2; l < N; l++)
	    {
	        for (int i = 1; i < N - l + 1; i++)
	        {
	            int j = i + l - 1;

	            // Initialize dp[i][j] with maximum value
	            dp[i][j] = Integer.MAX_VALUE;

	            for (int k = i; k <= j - 1; k++)
	            {
	                // Store the temporary cost (scalar multiplications) in 'temp' 
	                int temp = dp[i][k] + dp[k + 1][j]  + arr[i - 1] * arr[k] * arr[j];
	                
	                // If temporary answer 'temp' is less than actual aswer then update actual ans i.e dp[i][j]
	                dp[i][j] = Math.min(dp[i][j], temp);
	            }
	        }
	    }

	    // Return dp[1][N-1]
	    return dp[1][N - 1];
	}

}

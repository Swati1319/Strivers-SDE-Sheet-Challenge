public class Solution 
{

	public static int editDistance(String str1, String str2) 
	{

		int n = str1.length(), m = str2.length();
		int[][] dp = new int [n + 1][m + 1];

		// dp[i][j] stores the edit distance of the i+1th length substring of str1 and
		// and j+1th length substring of str2 starting from 0 index
		// Dynamically allocate memory of size N for each row
		for (int i = 0; i <= n; i++) 
		{
			for (int j = 0; j <= m; j++) 
			{
				// If first string is empty, only option is to
				// insert all characters of second string considering other string of j length
				// so min operation would be j

				if (i == 0) 
				{
					dp[i][j] = j;
				}

				else if (j == 0) 
				{
					dp[i][j] = i;
				}

				// If last characters are same, then it doesnt cost anything
				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
				{
					dp[i][j] = dp[i - 1][j - 1];
				}

				// If the last character is different, consider all
				// possibilities and find the minimum
				else 
				{
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
				}
			}
		}

		int ans = dp[n][m];

		return ans;
	}
}

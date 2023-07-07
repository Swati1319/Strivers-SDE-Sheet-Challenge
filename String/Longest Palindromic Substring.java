/*
    Time Complexity = O(N ^ 2)
    Space Complexity = O(N ^ 2)
    
    Where N is the length of the string.
*/

public class Solution {

	public static String longestPalinSubstring(String str) {

		int n = str.length();

		if (n < 1) {
			return "";
		}

		/*
			dp[i][j] will be true if str[i..j] is palindrome.
			Else dp[i][j] will be false.
		*/
		boolean[][] dp = new boolean[n][n];

		int maxLength = 1;

		// Single letter is always palindromic.
		for (int i = 0; i < n; ++i) {
			dp[i][i] = true;
		}

		int start = 0;

		// Substring of length 2.
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dp[i][i + 1] = true;
				
				if (maxLength < 2) {
					start = i;
					maxLength = 2;
				}
			}
		}

		/*
			Check for lengths greater than 2.
			k is length of substring.
		*/
		for (int len = 3; len <= n; len++) {

			// Fix the starting index.
			for (int i = 0; i < n - len + 1; ++i) {

				// Ending index of length len.
				int j = i + len - 1;

				// Condition of str[i,j] to be palindromic.
				if (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = true;

					// Update the starting index and the length.
					if (len > maxLength) {
						start = i;
						maxLength = len;
					}
				}

			}
		}

		return str.substring(start, start + maxLength);
	}

}

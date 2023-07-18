public class Solution {
    public static int lcs(String str1, String str2) {
        return LCSHelper(str1, str1.length(), str2, str2.length());
    }

    private static int LCSHelper(String str1, int n, String str2, int m) {
        int[][] dp = new int[2][m + 1];

        int currRowParity = 0;
        for (int i = 0; i <= n; i++) {
            currRowParity = i % 2;

            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[currRowParity][j] = 0;
                } else if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    /*
                         If the ith character of str1 is not equal to the jth character of str2,
                         we return the maximum of answers obtained by
                         1. Ignoring the ith character in the first string
                         2. Ignoring the jth character in the second string
                     */

                    dp[currRowParity][j] = Math.max(
                            dp[1 - currRowParity][j],
                            dp[currRowParity][j - 1]);
                } else {
                    /*
                         If the ith character of str1 is equal to the nth character of str2,
                         this character will be included in the subsequence.
                         Hence, we will add 1 to the length of lcs obtained
                         removing the mth character from the first string and the
                         nth character from the second string.
                     */
                    dp[currRowParity][j] = dp[1 - currRowParity][j - 1] + 1;
                }
            }
        }

        return dp[currRowParity][m];
    }

}

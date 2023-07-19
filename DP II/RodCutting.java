public class Solution {
	public static int cutRod(int price[], int n) {

		int cost[] = new int[n + 1];
		cost[0] = 0;
		int i, j;

		for (i = 1; i <= n; i++) {
			int maxCost = Integer.MIN_VALUE;

			for (j = 0; j < i; j++) {
				
				// Build the table in bottom up manner.
				maxCost = Math.max(maxCost, price[j] + cost[i - j - 1]);
			}

			// Contains maximum cost obtained from the rod of length 'i'.
			cost[i] = maxCost;
		}

		// Last entry contains maximum cost obtained from the rod of length 'n'.
		return cost[n];
	}
}

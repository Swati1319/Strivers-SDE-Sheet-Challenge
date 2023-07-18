import java.util.ArrayList;

public class Solution {

	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < w + 1; i++) {
			result.add(0);
		}

		// Loop to consider all the items
		for (int i = 0; i < n; i++) {
			// Loop to consider all the weights
			for (int j = w; j >= weights.get(i); j--) {
				result.set(j, Math.max(result.get(j), values.get(i) + result.get(j - weights.get(i))));
			}
		}

		// Return the final maximum profit
		return result.get(w);
	}
}

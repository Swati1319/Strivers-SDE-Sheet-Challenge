import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {

		int ans = Integer.MIN_VALUE;

		int productFromFront = 1, productFromBack = 1;

		for (int i = 0; i < n; i++) {
			productFromFront = productFromFront * arr.get(i);
			productFromBack = productFromBack * arr.get(n - i - 1);

			// Store the maximum of ans, productFromFront and productFromBack in the ans
			// variable.
			ans = Math.max(ans, Math.max(productFromFront, productFromBack));

			// If any of the products become 0, make them 1 again.
			if (productFromFront == 0) {
				productFromFront = 1;
			}
			if (productFromBack == 0) {
				productFromBack = 1;
			}
		}

		return ans;
	}
}

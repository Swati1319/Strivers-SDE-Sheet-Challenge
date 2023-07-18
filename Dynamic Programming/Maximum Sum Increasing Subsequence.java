
import java.util.ArrayList;

public class Solution 
{
	public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) 
	{
		ArrayList<Integer> dp = new ArrayList<Integer>(n);

		int totalWeight = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) 
		{
			dp.add(rack.get(i));
		}

		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				// Choose element which is smaller than last element.
				if (rack.get(i) > rack.get(j) && dp.get(i) < dp.get(j) + rack.get(i)) 
				{
					dp.set(i, dp.get(j) + rack.get(i));
				}
			}

			// Store the maximum weigth in 'totalWeight'.
			totalWeight = Math.max(totalWeight, dp.get(i));
		}

		return totalWeight;
	}
}

//Count Distinct Element in Every K Size Window


import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

		int n = arr.size();

		// Create an array to store the number of distinct elements in all windows
		ArrayList<Integer> answer = new ArrayList<Integer>(n - k + 1);

		// Maintain a HashMap to store the frequency of elements in the current window
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		// Add the frequency of first K element in the HashMap
		for (int i = 0; i < k; i++) {
			Integer j = hashMap.get(arr.get(i));
			hashMap.put(arr.get(i), (j == null) ? 1 : j + 1);
		}

		// Insert the number of distinct elements present in the first window in the array answer
		answer.add( hashMap.size());

		//  Iterate through all remaining windows
		for (int index = k; index < n; index++) {

			// Decrement the frequency of element in the HashMap by 1
			int element = arr.get(index - k);
			hashMap.put(element, hashMap.get(element) - 1);

			// Check if the frequency of element in the HashMap is 0
			if (hashMap.get(element) == 0) {
				hashMap.remove(element);
			}

			// Increment the frequency of ARR[index] in the HashMap by 1

			Integer j = hashMap.get(arr.get(index));
			hashMap.put(arr.get(index), (j == null) ? 1 : j + 1);

			// Insert the number of distinct elements present in the window in the array answer
			int windowNumber = index - k + 1;
			answer.add(hashMap.size());
		}

		// Return the array answer
		return answer;
	}
}

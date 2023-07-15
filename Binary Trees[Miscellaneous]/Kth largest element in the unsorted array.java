import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {

		// Initializing Priority queue with priority to the min element (functions as Min-Heap). 
		PriorityQueue<Integer> pq = new PriorityQueue<>();		
		int val;
		for (int i = 0; i < size; i++) {
			if (i < K) {
				pq.add(arr.get(i));
			}
			else {
				val = pq.peek();
				if (val < arr.get(i)) {
					pq.poll();
					pq.add(arr.get(i));
				}
			}
		}

		return pq.peek();
	}
}

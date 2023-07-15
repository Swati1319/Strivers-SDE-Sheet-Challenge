
import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {

    public static int[] findMedian(int[] arr, int n) {

        // To store the medians
        int[] medians = new int[n];

        // min heap
        PriorityQueue<Integer> lo = new PriorityQueue<>();

        // max heap
        PriorityQueue<Integer> hi = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {

            int num = arr[i];

            // Add to max heap
            lo.add(num);

            // Balancing step, that is inserting the current element at its position that is
            // either less than median or more than median value
            hi.add(lo.poll());

            // Maintain size property, as 'lo' can have utmost one more element than 'hi' or
            // both have equal number of elements
            if (lo.size() < hi.size()) {
                lo.add(hi.poll());

            }

            int median;

            // For odd number of elements
            if (lo.size() > hi.size()) {

                median = lo.peek();

            }
            // For even number of elements
            else {

                median = (lo.peek() + hi.peek()) / 2;

            }

            medians[i] = median;
        }

        return medians;

    }

}

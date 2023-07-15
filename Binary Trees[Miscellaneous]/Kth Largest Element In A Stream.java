

import java.util.PriorityQueue;

public class Kthlargest {
    private int size;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    Kthlargest(int k, int[] arr) {
        size = k;
        for (int it : arr) {
            pq.offer(it);
            if (pq.size() > size) {

                /*
                    Remove the top element from the queue
                    as soon as its size becomes greater than k.
                */
                pq.poll();
            }
        }
    }

    void add(int num) {
        pq.offer(num);
        if (pq.size() > size) {
            pq.poll();
        }
    }

    int getKthLargest() {
		
        /*
            The kth largest element will always
            be at the top of the queue.
        */
        return pq.peek();
    }
}

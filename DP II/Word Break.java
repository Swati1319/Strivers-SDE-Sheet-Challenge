import java.util.*;

public class Solution {
    public static boolean wordBreak(String[] arr, int n, String target) {
        // Declare a hash map.
        HashSet < String > hashMap = new HashSet < > ();

        // Insert all strings of a into hashmap.
        for (String s: arr) {
            hashMap.add(s);
        }

        // Declare an empty queue.
        Queue < Integer > q = new LinkedList < > ();

        // Declare an empty hash map to keep track of visited nodes.
        HashSet < Integer > visited = new HashSet < > ();

        // Push 0 to queue.
        q.add(0);

        // Run a loop until q is not empty.
        while (q.size() > 0) {
            // Pop front element of queue.
            int frontElement = q.peek();
            q.remove();

            // Check if front element is already visited or not.
            if (!visited.contains(frontElement)) {
                // Mark front element as visited.
                visited.add(frontElement);

                // Run a loop from front element to size of target string.
                for (int j = frontElement; j < target.length(); j++) {
                    /*
                        If substring starting from j does 
                        not exist in hash map then push it to queue.
                    */
                    if (hashMap.contains(target.substring(frontElement, j + 1))) {
                        q.add(j + 1);

                        /*
                            If we have reached at the end of 
                            target String then return true.
                        */
                        if (j + 1 == target.length())
                            return true;
                    }
                }
            }
        }

        return false;
    }
}

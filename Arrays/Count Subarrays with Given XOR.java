import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
    
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(0, 1);  // Store 0th index XOR as 0 in visited

        int cpx = 0;
        int c = 0;

        for (int i = 0; i < arr.size(); i++) {
            cpx ^= arr.get(i);

            int h = cpx ^ x;
            if (visited.containsKey(h)) {
                c += visited.get(h);
            }

            visited.put(cpx, visited.getOrDefault(cpx, 0) + 1);
        }

        return c;
    }
}

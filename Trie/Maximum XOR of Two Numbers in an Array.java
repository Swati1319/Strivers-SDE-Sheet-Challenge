import java.util.*;
public class Solution {

    public static int maximumXor(int[] A) {
        
        int ans = 0;
    
        int mask = 0;
        int n = A.length;
        
        for (int i = 30; i >= 0; i--)
        {   
            HashSet<Integer> s = new HashSet<>();

            // Setting the ith bit 1 in mask.
            mask = mask | (1 << i);

            for (int j = 0; j < n; j++)
            {   
                // Inserting prefix bitmask into the set.
                s.add(A[j] & mask);
            }

            int tempAns = ans;

            // Setting the ith bit 1.
            tempAns = tempAns | (1 << i);

            for(Integer it: s)
            {   
                // Checking if 'it' xor 'tempAns' is present in set. 
                if(s.contains(it ^ tempAns))
                {   
                    ans = tempAns;
                    break;
                }
            }
        } 

        return ans;
    }
}

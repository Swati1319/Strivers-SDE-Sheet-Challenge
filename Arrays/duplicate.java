import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] ans = new int[2];
        for(int i = 1;i<=n;i++)
        {
            if(arr.contains(i))
            {
                arr.remove(arr.indexOf(i));
            }
            else{
                ans[0] = i;
            }
        }
        ans[1] = arr.get(0);
        return ans;
    }
}

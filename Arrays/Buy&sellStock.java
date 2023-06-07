import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int n= prices.size();
        int maxP = 0;
        int minP = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++ )
        {
            minP = Math.min(minP,prices.get(i));
            maxP = Math.max(maxP,prices.get(i) - minP);
        }

        return maxP;
    }
}

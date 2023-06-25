//Longest Substring Without Repeating Characters

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int uniqueSubstrings(String input) 
    {
        HashMap<Character, Integer> set = new HashMap<>();  
        
        int maxLength = 0;
        int low = 0;

        for(int high = 0; high < input.length(); high++)
        {
            char ch = input.charAt(high);
            
            if(set.containsKey(ch) && set.get(ch) >= low)
            low = set.get(ch) + 1;

            set.put(ch, high);
            maxLength = Math.max(maxLength, high - low + 1);
        }

        return maxLength;
    }
}

import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] nums, int n) {
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        
        for(int i = 1;i < n; i++){
            if(nums[i] != nums[i - 1])
                if(nums[i] == nums[i - 1] + 1)      count += 1;
                    
                else{
                    max = Math.max(max,count);
                    count = 1;
                }
        }
        return Math.max(max, count);
    }
}

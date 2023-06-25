import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int n = arr.size();
        int major1 = 0;
        int major2 = 0;
        int count1 = 0;
        int count2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int element : arr) {
            if(major1 == element) {
                count1++;
            }
            else if(major2 == element) {
                count2++;
            }
            else if(count1 == 0) {
                major1 = element;
                count1++;
            }
            else if(count2 == 0) {
                major2 = element;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int element : arr) {
            if(major1 == element) {
                count1++;
            }
            if(major2 == element) {
                count2++;
            }
        }

        if(count1 > n / 3) {
            ans.add(major1);
        }
        if(count2 > n / 3) {
            ans.add(major2);
        }

        return ans;
    }
}

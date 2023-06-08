import java.util.* ; 
import java.io.*; 
/*******************************************************

   Following is the Interval class structure

   class Interval {        int start, int finish;

       Interval(int start, int finish) {            this.start = start;            this.finish = finish;        }    }     *******************************************************/

 

 

 

import java.util.List; import java.util.ArrayList;

public class Solution {   
     public static List<Interval> mergeIntervals(Interval[] intervals) 
     {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals.length == 0 || intervals == null) return res;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals[0].start;
        int end = intervals[0].finish;
        for(int i = 0; i < intervals.length; i++) 
        {
            if(intervals[i].start <= end)
            {
                end = Math.max(end, intervals[i].finish);
                }
                else
                {
                    res.add(new Interval(start, end));
                    start = intervals[i].start;
                    end = intervals[i].finish;
                }
            } 
        res.add(new Interval(start, end));
        return res;
     }
 }  

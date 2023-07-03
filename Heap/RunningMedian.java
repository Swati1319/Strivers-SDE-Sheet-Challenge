import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class Solution {
	public static void findMedian(int arr[])  {
        if(arr.length==0)return;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        System.out.print(arr[0]+" ");
        max.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=max.peek()){
                max.add(arr[i]);
            }
            else{
                min.add(arr[i]);
            }
            if(max.size() > min.size()+1){
                min.add(max.remove());
            }
            else if(min.size() > max.size()){
                max.add(min.remove());
            }
            if(max.size()==min.size()){
                System.out.print((int)(max.peek()+min.peek())/2+" ");
            }
            else{
                System.out.print(max.peek()+" ");
            }
        }
    }
}

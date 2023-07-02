import java.util.* ;
import java.io.*; 
public class Solution {

    static void findSumSet(int arr[],ArrayList<Integer>list,int idx,int sum){
        sum += arr[idx];
        list.add(sum);
        for(int i = idx+1;i<arr.length;i++){
            findSumSet(arr,list,i,sum);
        }
        sum-=arr[idx];
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<num.length ; i++)
        {
            findSumSet(num,list,i,0);
        }
        list.add(0);
        Collections.sort(list);
        return list;
    }

}

import java.util.* ;
import java.io.*; 
public class Solution {

     public static void findSubsets(int ind, int[] nums, List<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
       ansList.add(new ArrayList<>(ds)); 
       for(int i = ind;i<nums.length;i++) {
           if(i!=ind && nums[i] == nums[i-1]) continue; 
           ds.add(nums[i]); 
           findSubsets(i+1, nums, ds, ansList); 
           ds.remove(ds.size() - 1);
       }
       
   }
   public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
       // Write your code here..
      Arrays.sort(arr); 
       ArrayList<ArrayList<Integer>> ansList = new ArrayList<>(); 
       findSubsets(0, arr, new ArrayList<>(), ansList); 
       return ansList; 
   }
}

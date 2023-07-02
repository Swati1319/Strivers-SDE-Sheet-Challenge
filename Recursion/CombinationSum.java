import java.util.ArrayList;

public class Solution 
{
    static void find(int ind,int n,int tar,ArrayList<ArrayList<Integer>> al,ArrayList<Integer> arr,ArrayList<Integer> ds){
        if(ind==n){
            if(tar==0){
                al.add(new ArrayList<>(ds));
            }
            return;
        }
    
        ds.add(arr.get(ind));
        find(ind+1, n, tar-arr.get(ind), al, arr, ds);
        ds.remove(ds.size()-1);
        find(ind+1,n,tar,al,arr,ds);
        
    }
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int tar) 
	{
        // Write your code here.
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();

        find(0,n,tar,al,arr,new ArrayList<>());
        return al;
    }
}

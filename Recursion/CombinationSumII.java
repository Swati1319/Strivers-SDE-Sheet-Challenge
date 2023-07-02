import java.util.*;

 

public class Solution 

{

    static ArrayList<ArrayList<Integer>> list;

    static ArrayList<Integer> list2;

    static Set<String> set;

    static void combinationSum(ArrayList<Integer> arr,int n,int idx,int sum,int target,String s){

        if(sum==target){

            if(!set.contains(s)){

                set.add(s);

                list.add(new ArrayList<>(list2));

            }

            

            return;

        }

        if(idx>=n || sum>target)return ;

        list2.add(arr.get(idx));

        combinationSum(arr, n, idx+1, sum+arr.get(idx), target,s+arr.get(idx));

        list2.remove(list2.size()-1);

        combinationSum(arr, n, idx+1, sum, target,s);

        return ;

    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)

    {

        //    Write your code here.

        Collections.sort(arr);

        list=new ArrayList<>();

        list2=new ArrayList<>();

        set=new HashSet<>();

        combinationSum(arr,n,0,0,target,"");

        return list;

    }

}

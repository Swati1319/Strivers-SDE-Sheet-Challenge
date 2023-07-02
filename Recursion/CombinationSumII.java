import java.util.*;

 

public class Solution 

{

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)

    {

        Collections.sort(arr);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> inner = new ArrayList<>();

        func(arr, target, res, inner, 0);

        return res;

    }

    public static void func(ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> inner, int ind)

    {

        

          if(target == 0)

          {

               res.add(new ArrayList<>(inner));

               return;

          }  

          for(int i=ind;i<arr.size();i++)

          {

            if( i > ind && arr.get(i) == arr.get(i-1) )

            {

               continue;

            }

            if (arr.get(i) > target) break;

            if(arr.get(i) <= target )

            {

            

            inner.add(arr.get(i));

            func( arr, target - arr.get(i), res, inner, i+1);

            inner.remove(inner.size()-1);

            }

          }  
    }

}

import java.util.*;

 

public class Solution {

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {

        int ans1 = quickSelect(arr,n,k-1,0,n-1);

        int ans2 = quickSelect(arr,n,n-k,0,n-1);

        ArrayList<Integer>ans = new ArrayList<>();

        ans.add(ans1);

        ans.add(ans2);

        return ans;

    }

    public static int quickSelect(ArrayList<Integer>arr,int n,int k,int i,int j){

        if(i==j){

            return arr.get(i);

        }

        int idx = partition(arr,i,j);

        if(idx==k){

            return arr.get(idx);

        }

        else if(idx<k){

            return quickSelect(arr,n,k,idx+1,j);

        }

        else{

            return quickSelect(arr,n,k,i,idx-1);

        }

    }

    public static int partition(ArrayList<Integer>arr,int start,int end){

        int pivot = start;

        int i = start-1;

        for(int j = start;j <= end;j++){

            if(arr.get(j)<=arr.get(pivot)){

                i++;

                int temp = arr.get(i);

                arr.set(i,arr.get(j));

                arr.set(j,temp);

                

            }

        }

        int temp = arr.get(i);

        arr.set(i,arr.get(pivot));

        arr.set(pivot,temp);

        return i;

    }

}

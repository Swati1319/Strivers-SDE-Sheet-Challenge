import java.io.*;

import java.util.* ;

 

public class Solution {

    public static int findMajority(int[] arr, int n) {

        // Write your code here.

        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i=0; i<arr.length; i++){

            if(h.containsKey(arr[i])){

                h.put(arr[i],h.get(arr[i])+1);

            }else{

                h.put(arr[i],1);

            }

        }

        for(Map.Entry<Integer,Integer> entry : h.entrySet()){

            int a = entry.getValue();

            if(a>(n/2)){

                return entry.getKey();

            }

        }

        return -1;

    }

}

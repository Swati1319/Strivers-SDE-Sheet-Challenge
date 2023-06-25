import java.io.*;

import java.util.* ;

 

import java.util.ArrayList;

 

public class Solution {

 

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefixSum = 0;

        int maxi=0;

        for(int i=0;i<arr.size();i++){

            prefixSum = prefixSum + arr.get(i);

            if(map.containsKey(prefixSum)){

                maxi = Math.max(maxi,(i-map.get(prefixSum)));

            }

            else if(prefixSum==0){

                maxi = i+1;

            }

            else{

                map.put(prefixSum,i);

            }

        }

        return maxi;

    }

}

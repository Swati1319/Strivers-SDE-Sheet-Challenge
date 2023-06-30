import java.util.* ;

import java.io.*; 

public class Solution {

    public static long getTrappedWater(long[] arr, int n) {

    

    //calculate left max boundary - array 

    long leftmax[] = new long[n];

    leftmax[0] = arr[0];

    for(int i=1; i<n; i++) {

        leftmax[i] = Math.max(leftmax[i-1], arr[i]);

    }

    //calculate right max boundary - array 

    long rightmax[] = new long[n];

    rightmax[n-1] = arr[n-1];

    for(int i=n-2; i>=0; i--) {

        rightmax[i] = Math.max(rightmax[i+1], arr[i]);

    }

    //loop 

    long trapedwater = 0;

    for(int i=0; i<n; i++) {

        //waterLevel = min(leftmax bound, rigthmax bound)

        long waterlevel = Math.min(leftmax[i], rightmax[i]);

        

        //trapped water = water level - height[i]

        trapedwater += waterlevel - arr[i];

    }

    return trapedwater;

    }

}

import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
          int i = m-1;
          int j = n-1;
          int k = m+n-1;
          while(j>=0){
              if(i>=0 && arr1[i] > arr2[j]){
                  arr1[k--] = arr1[i--];
                  }

              else{
                  arr1[k--] = arr2[j--];
                  }
            }
            return arr1;
    }
}

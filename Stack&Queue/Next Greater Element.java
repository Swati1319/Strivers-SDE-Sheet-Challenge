import java.util.* ;

import java.io.*; 

 

public class Solution {

    

    public static int[] nextGreater(int[] arr, int n) {

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

 

        for(int i = n-1; i >= 0; i--){

            while(!st.isEmpty() && arr[i] >= st.peek()) st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);

        }

        return ans;

    }

 

}

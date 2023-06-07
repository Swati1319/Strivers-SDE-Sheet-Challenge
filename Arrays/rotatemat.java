import java.io.*; 

import java.util.* ;

 

public class Solution {    

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        // Write your code here.

        int u = 0;

        int d = n-1;

        int l = 0;

        int r = m-1;

        while (l<r && u<d) {

            int prev = mat.get(u+1).get(l);

            for (int i=l;i<=r;i++) { 

               int curr = mat.get(u).get(i);

                mat.get(u).set(i,prev);

                prev = curr;

            }

            u++; 

           for (int i=u;i<=d;i++) {

                int curr = mat.get(i).get(r);

                mat.get(i).set(r,prev); 

               prev = curr;

            }

            r--;

            for (int i=r;i>=l;i--) {

                int curr = mat.get(d).get(i);

                mat.get(d).set(i,prev);

                prev = curr; 

           }

            d--;

            for (int i=d;i>=u;i--) {

                int curr = mat.get(i).get(l);

                mat.get(i).set(l,prev);

                prev = curr;

            }

            l++;

        }

    }

 }  

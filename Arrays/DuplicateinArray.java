import java.io.*;

import java.util.* ;

 

import java.util.ArrayList;

 

public class Solution{

public static int findDuplicate(ArrayList<Integer> arr, int n){

// Write your code here.

for(int i=0; i<arr.size() ; i++){

int idx = Math.abs(arr.get(i)) - 1;

 

if(arr.get(idx)>0) arr.set(idx,-arr.get(idx));

else return Math.abs(arr.get(i));

 

}

 

return -1;

}

 

}

 

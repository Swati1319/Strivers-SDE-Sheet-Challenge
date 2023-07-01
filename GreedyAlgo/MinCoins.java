import java.util.* ;

import java.io.*;

public class Solution

{

public static int findMinimumCoins(int amount)

{

// Write your code here.

int arr[] = new int[]{1000,500,100,50,20,10,5,2,1};

int count=0;

int i=0;

while(i<arr.length){

if(amount==0) break;

if(amount >= arr[i]){

count++;

amount -= arr[i];

}

else{

i++;

}

}

return count;

}

}

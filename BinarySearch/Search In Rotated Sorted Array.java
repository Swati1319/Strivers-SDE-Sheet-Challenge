public class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
         int start=0,end=arr.length-1;

        while(start<=end){

           int mid=(start+end)/2;

            if(arr[mid]==key){

                return mid;

                }

             if(arr[start]<=arr[mid]){          //finding sorted array

             if(arr[start]<=key && key<=arr[mid]){

               end=mid-1;

             }

               else{

               start=mid+1;

               }

               

             }

             else{

                 if(arr[mid]<=key && key<=arr[end]){

                 start=mid+1;

                 }

                 else{

                 end=mid-1;

                 }

             }

 

        }

        return -1;

    }

}

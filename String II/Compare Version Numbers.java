import java.util.* ;

import java.io.*; 

public class Solution 

{

    public static int compareVersions(String a, String b) 

    {

        // Write your code here

      String[] str1 = a.split("\\.");

       String[] str2 = b.split("\\.");

       int i =0;

       int j =0;

       while(i<str1.length && j <str2.length){

           if(str1[i].length() > str2[j].length()){

               return 1;

           }

            if(str1[i].length() < str2[j].length()){

               return -1;

           }

           int m=0;

           int n=0;

           while(m<str1[i].length()){

               if(str1[i].charAt(m)-'0' > str2[j].charAt(n)-'0'){

                   return 1;

               }

                 if(str1[i].charAt(m)-'0' < str2[j].charAt(n)-'0'){

                   return -1;

               }

               m++;

               n++;

           }

           i++;

           j++;

       }

       while(i <str1.length){

           int m=0;

           while(m <str1[i].length()){

               if(str1[i].charAt(m)-'0' !=0){

                   return 1;

               }

               m++;

           }

           i++;

       }

       while(j < str2.length){

           int n =0;

           while(n <str2[j].length()){

               if(str2[i].charAt(n)-'0' !=0){

                   return -1;

               }

               n++;

           }

           j++;

       }

       return 0;

    }

}

import java.util.* ;
import java.io.*; 
public class Solution {
   public static boolean areAnagram(String str1, String str2){

        if(str1.length()!=str2.length())return false;
        char s1[] = str1.toCharArray();

        Arrays.sort(s1);

        str1 = new String(s1);

        char s2[]= str2.toCharArray();

        Arrays.sort(s2);

        str2 = new String(s2);

 

        return str1.equals(str2);

    }



    }

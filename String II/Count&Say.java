import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static String writeAsYouSpeak(int n) 

    {

        // Write your code here.

 

        String s="1";

        for(int i=1;i<n;i++){

            int count=1;

            StringBuilder sb=new StringBuilder();

            for(int j=1;j<s.length();j++){

                if(s.charAt(j-1)==s.charAt(j)){

                    count++;

                }

                else{

                    sb.append(count).append(s.charAt(j-1));

                    count=1;

                }

            }

            sb.append(count).append(s.charAt(s.length()-1));

            

            s=sb.toString();

        }

        return s;

    }
}

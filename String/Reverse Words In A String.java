public class Solution 

{

    public static String reverseString(String str) 

    {

        //Write your code here

        StringBuilder sb=new StringBuilder();

        String[] s=str.split("\\s+");

        for(int i=s.length-1;i>=0;i--)

        {

            sb.append(s[i]+" ");

        }

        return sb.toString().trim();

    }

}

 

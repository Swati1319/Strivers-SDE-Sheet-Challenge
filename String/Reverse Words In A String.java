public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		String[] s = str.split(" ");
		String ss = "";
		for(int i=s.length-1;i>=0;i--){
			ss+=s[i].trim()+" ";
		}
		return ss;
	}
}

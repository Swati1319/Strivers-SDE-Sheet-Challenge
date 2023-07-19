import java.util.*; 
	public class Solution 
	{ 
		public static String longestCommonPrefix(String[] arr, int n) {
			  // Write your code here                
			  Arrays.sort(arr,(a,b)->  a.compareTo(b));        
			  String tmp1=arr[0];        
			  String tmp2=arr[n-1];        
			  String ans="";        
			  for(int i=0;i<tmp1.length();i++)        
			  {            
				  if(tmp1.charAt(i)==tmp2.charAt(i))            
				  {                
					  ans+=tmp1.charAt(i);            
					}            
					else{               
						 break;            
						}        
				}        
			return ans;         
		}             
	} 

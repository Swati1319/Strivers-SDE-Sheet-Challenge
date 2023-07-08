public class Solution {

   public static int minCharsforPalindrome(String s) {        
       //Base Case        
       if(s.length() == 0 || s.length() == 1) {            
           return 0;        
        }        
        int j = s.length()-1;        
        while(!isPalin(0, j, s)){            
            j--;        
        }        
        String st = s.substring(j+1);        
        return st.length();    
        }     
        public static boolean isPalin(int i, int j, String s){        
            while(i<=j){            
                if(s.charAt(i)!=s.charAt(j)){                
                    return false;            
                }            
                i++;            
                j--;        
            }        
        return true;    
    }

}

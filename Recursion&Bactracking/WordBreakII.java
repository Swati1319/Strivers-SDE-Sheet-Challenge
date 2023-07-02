import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
 // Write your code here.
 HashSet<String> h=new HashSet<>();
 for(String str:dictionary){
  h.add(str);
 }
 ArrayList<String> res=new ArrayList<>();
 solve(0,s,new ArrayList<>(),h,res);
 return res;

 
}
public static void solve(int ind,String s,List<String>ls,HashSet<String> h,ArrayList<String> res){
 if(ind==s.length()){
  StringBuilder str=new StringBuilder();
  for(int i=0;i<ls.size();i++){
   str.append(ls.get(i));
   str.append(" ");
  }
  res.add(str.toString());
  return ;
 }
 for(int i=ind;i<s.length();i++){
  if(h.contains(s.substring(ind,i+1))){
   ls.add(s.substring(ind,i+1));
   solve(i+1,s,ls,h,res);
   ls.remove(ls.size()-1);
  }
 }
}
}

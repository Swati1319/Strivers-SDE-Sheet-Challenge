import java.util.* ;

import java.io.*;

public class Solution {

public static List<Integer> maximumMeetings(int[] start, int[] end) {

//Write your code here

int n=start.length;

List<List<Integer>> lss=new ArrayList<>();

for(int i=0;i<n;i++){

List<Integer> ls=new ArrayList<>();

ls.add(start[i]);

ls.add(end[i]);

ls.add(i);

lss.add(ls);

}

Collections.sort(lss,(a,b)->(a.get(1)-b.get(1)));

List<Integer> l1=new ArrayList<>();

int e1=lss.get(0).get(1);

l1.add(lss.get(0).get(2)+1);

for(int i=1;i<lss.size();i++){

if(e1<lss.get(i).get(0)){

l1.add(lss.get(i).get(2)+1);

e1=lss.get(i).get(1);

}

}

return l1;

}

}

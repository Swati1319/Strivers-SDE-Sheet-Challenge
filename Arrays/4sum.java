import java.io.*;

import java.util.* ;

 

public class Solution {

 

 

  public static boolean comPair(Pair p1,Pair p2){

    if(p1.x==p2.x||p1.x==p2.y||p1.y==p2.x||p1.y==p2.y)return false;

    return true;

  }

  public static String fourSum(int[] arr, int target, int n) {

      // Write your code here.

      Map<Integer,Set<Pair>> map=new HashMap<>();

      for(int i=0;i<n-1;i++){

        for(int j=i+1;j<n;j++){

          Pair p=new Pair(arr[i], arr[j]);

          int key=arr[i]+ arr[j];

          if(map.containsKey(target-key)){

            for(Pair pair:map.get(target-key)){

              if(comPair(pair, p)){

                return "Yes";

              }

            }

          }

 

          if(map.containsKey(key)){

            map.get(key).add(p);

          }

          else{

          Set<Pair> set=new HashSet<>();

          set.add(p);

          map.put(key, set);

          }

 

        }

      }

      return "No";

  }

}

 class Pair{

    public int x,y;

    public Pair(int x,int y){

      this.x=x;

      this.y=y;

    }

  }

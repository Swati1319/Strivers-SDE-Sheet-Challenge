public class Solution {
   public static double maximumValue(Pair[] items, int n, int w) {
           // Write your code here.
        // ITEMS contains {weight, value} pairs.
       Arrays.sort(items,new Comparator<Pair>(){
           public int compare(Pair i1, Pair i2) {
               return i2.value*i1.weight - i2.weight * i1.value;
           }
       });
       double ans = 0;
       for(int i =0;i<n;i++) {
           if(w>=items[i].weight) {
               ans += items[i].value;
               w -= items[i].weight;
           } else {
               ans += (double)items[i].value*w/(double)items[i].weight;
               break;
           }
       }
       return ans;
   }
}

import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        int row=0;
        int l=mat.size()-1,f=0;
        while(f<=l){
            int m = f + (l -f) / 2;
            if(mat.get(m).get(0)==target) return true;
            else if(mat.get(m).get(0)<target){
                row=m;
                f=m+1;
            }else{
                l=m-1;
            }
        }
        l=mat.get(0).size()-1;
        f=0;
        while(f<=l){
            int m = f + (l -f) / 2;
            if(mat.get(row).get(m)==target) return true;
            else if(mat.get(row).get(m)<target){
                f=m+1;
            }else{
                l=m-1;
            }
        }
        return false;
    }
}

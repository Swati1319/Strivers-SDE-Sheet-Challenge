import java.util.*;
import java.io.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int i = 1;
        int j = 0;
        int need = 1;
        int max = 1;
        while(i<n && j<n){
            if(at[i] <= dt[j]){
                need++;
                i++;
            }
            else if(at[i] > dt[j]){
                need--;
                j++;
            }
            max = Math.max(max, need);
        }
        return max;
    }
}

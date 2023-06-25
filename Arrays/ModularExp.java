import java.io.*;
import java.util.* ;

public class Solution {
    public static long findExp(long x,long n,long m){
        if(n==0)return 1;
        long sq = findExp(x,n/2,m);
        long res = (sq * sq)%m;
        if(n%2==1)return (res*x)%m;
        return res;
    }
    public static int modularExponentiation(int x, int n, int m) {
        return (int)findExp((long)x,(long)n,(long)m);
    }
}

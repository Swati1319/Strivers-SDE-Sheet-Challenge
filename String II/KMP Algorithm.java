import java.util.* ;
import java.io.*; 
public class Solution {
    public static void getLps(String p, int[] lps) {

        int len = 0;
        int index = 1;
        int m = p.length();

        while (index < m) {

            if (p.charAt(index) == p.charAt(len)) {

                len += 1;
                lps[index] = len;
                index += 1;
            }
            else {
                if (len == 0) {
                    lps[index] = 0;
                    index += 1;
                }

                else {
                    // Skipping the characters.
                    len = lps[len - 1];
                }
            }
        }
    }

    public static boolean findPattern(String p, String s) {

        int m = p.length();
        int n = s.length();
        int[] lps = new int[m];

        for (int i = 0; i < m; i++) {
            lps[i] = 0;
        }

        getLps(p, lps);

        // We will use these indices to traverse in s and p.
        int index1 = 0;
        int index2 = 0;

        while (index1 < n) {

            if (s.charAt(index1) == p.charAt(index2)) {

                index2++;
                index1++;

                if (index2 == m) {
                    return true;
                }

                if (index1 == n) {
                    return false;
                }

            }
            else {
                if (index2 == 0) {
                    index1 += 1;
                }
                else {
                    // Skipping the characters.
                    index2 = lps[index2 - 1];
                }
            }
        }

        return false;
    }
}

import java.util.ArrayList;
import java.util.List;
public class Solution {

    private static final int MOD = 1000000007;

    private static long modPower(long a, long b) {
        if (b == 0)
            return 1;

        long p = modPower(a, b / 2);

        if (b % 2 == 1)
            return p * p % MOD * a % MOD;

        return p * p % MOD;
    }
    public static List< Integer > stringMatch(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        // List storing the indices of occurrences
        List<Integer> ans = new ArrayList<>();

        long maxPow = modPower(26, m - 1);

        long hashPattern = 0, hashText = 0;
        for (int i = 0; i < m; i++) {
            hashPattern = hashPattern * 26 + pattern.charAt(i) - 'a';
            hashPattern %= MOD;
        }
        for (int i = 0; i < m - 1; i++) {
            hashText = hashText * 26 + text.charAt(i) - 'a';
            hashText %= MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            hashText = hashText * 26 + text.charAt(i + m - 1) - 'a';
            hashText %= MOD;

            if (hashText == hashPattern) {
                // Adding the last character in hash
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    // If a character mismatch occurs
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    ans.add(i + 1);
                }
            }

            // Removing the first character in hash
            hashText = hashText - maxPow * (text.charAt(i) - 'a');
            hashText %= MOD;
            hashText = (hashText + MOD) % MOD;
        }

        return ans;
    }
}

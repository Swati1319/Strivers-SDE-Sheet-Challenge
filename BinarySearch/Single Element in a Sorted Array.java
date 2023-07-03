import java.util.ArrayList;

public class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size();
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Update low and high
            if (mid % 2 == 1) {
                int a = arr.get(mid);
                int b = arr.get(mid - 1);

                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else if (mid % 2 == 0) {
                int a = arr.get(mid);
                int b = arr.get(mid + 1);

                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return arr.get(low);
    }
}

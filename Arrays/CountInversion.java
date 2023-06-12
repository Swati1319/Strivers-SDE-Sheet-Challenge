public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        int l = 0, r = (n - 1);
        return mergeSort(arr, l, r);
    }

    static long merge(long arr[], int l, int m, int r) {
        long cnt = 0;
        int i = l, j = m + 1, ci = 0;
        long temp[] = new long[r - l + 1];
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[ci++] = arr[i++];
            } else {
                temp[ci++] = arr[j++];
                cnt += (m - i + 1); // Increment count for inversions
            }
        }
        while (i <= m) {
            temp[ci++] = arr[i++];
        }
        while (j <= r) {
            temp[ci++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
        return cnt;
    }
    
    static long mergeSort(long arr[], int l, int r) {
        long cnt = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            cnt += mergeSort(arr, l, m);
            cnt += mergeSort(arr, m + 1, r);
            cnt += merge(arr, l, m, r);
        }
        return cnt;
    }

}

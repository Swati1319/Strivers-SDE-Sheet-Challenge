public class Solution {

    public static int ninjaAndLadoos(int nums1[], int nums2[], int m, int n, int l) 

    {

        int finalArray[] = new int[n + m];

        int i = 0, j = 0, k = 0;

 

        while (i < m && j < n) {

            if (nums1[i] < nums2[j]) {

                finalArray[k++] = nums1[i++];

            } else {

                finalArray[k++] = nums2[j++];

            }

        }

 

        if (i < m) {

            while (i < m)

                finalArray[k++] = nums1[i++];

        }

 

        if (j < n) {

            while (j < n)

                finalArray[k++] = nums2[j++];

        }

 

        int low = 0;

        int high = m + n;

 

        while (low <= high) {

            int mid = (low + high) / 2;

            if (mid == l) {

                return finalArray[mid-1];

            } else {

                if (mid < l) {

                    low = mid + 1;

                } else {

                    high = mid - 1;

                }

            }

        }

 

        return -1;

    }

}

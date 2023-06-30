import java.util.*;

 

public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {

        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

 

        // Sort the array in ascending order

        Arrays.sort(arr);

 

        // Fix the first element and find the other two

        for (int i = 0; i < n - 2; i++) {

            // Check if the current element is the same as the previous element

            if (i > 0 && arr[i] == arr[i - 1]) {

                continue;

            }

 

            int j = i + 1;

            int k = n - 1;

 

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

 

                if (sum == K) {

                    ArrayList<Integer> triplet = new ArrayList<>();

                    triplet.add(arr[i]);

                    triplet.add(arr[j]);

                    triplet.add(arr[k]);

                    triplets.add(triplet);

 

                    // Skip duplicate elements for j and k

                    while (j < k && arr[j] == arr[j + 1]) {

                        j++;

                    }

                    while (j < k && arr[k] == arr[k - 1]) {

                        k--;

                    }

 

                    // Move j and k pointers

                    j++;

                    k--;

                } else if (sum < K) {

                    // Move j pointer

                    j++;

                } else {

                    // Move k pointer

                    k--;

                }

            }

        }

 

        return triplets;

    }

 

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int n = arr.length;

        int K = 16;

        ArrayList<ArrayList<Integer>> triplets = findTriplets(arr, n, K);

 

        for (ArrayList<Integer> triplet : triplets) {

            System.out.println(triplet);

        }

    }

}

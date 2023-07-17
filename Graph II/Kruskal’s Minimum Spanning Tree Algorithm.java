import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

// Custom comparator to sort the edges.
class SortCompare implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return a.get(2).compareTo(b.get(2));
    }
}

public class Solution {
    // Creates a new set consisting of the new element v.
    private static void make_set(int v, ArrayList<Integer> parent, ArrayList<Integer> rank) {
        parent.add(v);
        rank.add(0);
    }

    // Returns the parent of the set that contains the element v.
    private static int find_set(int v, ArrayList<Integer> parent) {
        if (v == parent.get(v)) {
            // Current element is the parent of its set.
            return v;
        } 
        else {
            // Using path compression technique.
            parent.set(v, find_set(parent.get(v), parent));
            return parent.get(v);
        }
    }

    // Merges the two specified sets.
    private static void union_sets(int a, int b, ArrayList<Integer> parent, ArrayList<Integer> rank) {
        // Find the parent of both elements.
        a = find_set(a, parent);
        b = find_set(b, parent);

        if (a != b) {
            if (rank.get(a) < rank.get(b)) {
                // Swap.
                int t = a;
                a = b;
                b = t;
            }

            parent.set(b, a);
            if (rank.get(a) == rank.get(b)) {
                rank.set(a, rank.get(a) + 1);
            }
        }
    }

    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Parent and rank arrays to be used in DSU.
        ArrayList<Integer> parent = new ArrayList<Integer>(n + 1);
        ArrayList<Integer> rank = new ArrayList<Integer>(n + 1);

        for (int i = 0; i <= n; i++) {
            // Create a new set for each node.
            make_set(i, parent, rank);
        }

        // To store the weight of MST.
        int cost = 0;

        // Sort the edges in ascending order by its weight.
        Collections.sort(graph, new SortCompare());

        // Start traversign through the edges.
        for (ArrayList<Integer> edge : graph) {
            // Check if both vertices of current edge belong to different sets(subtrees).
            if (find_set(edge.get(0), parent) != find_set(edge.get(1), parent)) {
                // Add the weight of the current edge.
                cost = cost + edge.get(2);

                // Merge the two sets(subtrees).
                union_sets(edge.get(0), edge.get(1), parent, rank);
            }
        }
        return cost;
    }
}

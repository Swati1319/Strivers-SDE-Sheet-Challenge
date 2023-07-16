import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (edges.get(i).get(j) == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);

                }
            }
        }

        ArrayList<Integer> color = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            color.add(-1);
        }

        // Marking the color of root as 0.
        for (int i = 0 ; i < n ; i++) {
            if (color.get(i) != -1) {
                continue;
            }
            color.set(i, 0);

            Queue<Integer> que = new LinkedList<Integer>();

            que.add(i);
            int c = 0;

            while (que.size() != 0) {
                int node = que.poll();

                // Traversing all the neighbours of the current node.
                for (int nbr : graph.get(node)) {
                    if (color.get(nbr) != -1 && color.get(nbr) == color.get(node)) {
                        return false;
                    } else if (color.get(nbr) == -1) {
                        color.set(nbr, 1 - color.get(node));
                        que.add(nbr);
                    }
                }
                c = 1 - c;
            }
        }

        return true;
    }
}

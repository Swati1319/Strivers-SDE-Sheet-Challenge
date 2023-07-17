import java.util.ArrayList;

public class Solution {

    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

        // Stores the shortest path between two vertices.
        int[][] d = new int[n + 1][n + 1];

        // Initialize all the values to 1e9 except i, i which initializes to 0.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = 1000000000;
                }
            }
        }
        // Add all edges to the matrix.
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            d[u][v] = w;
        }

        // Apply Flloyd Warshall's Algorithm.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] != 1000000000 && d[k][j] != 1000000000) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }

        // Return dist between src and dest.
        return d[src][dest];

    }

}

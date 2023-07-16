public class Solution {
  public static int findparent(int i, int[] parent) {
    if (i == parent[i]) {
      return i;
    }
    return parent[i] = findparent(parent[i], parent);
  }

  public static String cycleDetection(int[][] edges, int n, int m) {

    int[] parent = new int[n + 1];
    int[] rank = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      rank[i] = 1;
      parent[i] = i;
    }

    for (int[] ar: edges) {
      int u = ar[0];
      int v = ar[1];

      int p1 = findparent(u, parent);
      int p2 = findparent(v, parent);

      if (p1 != p2) {
        if (rank[p1] < rank[p2]) {
          parent[p1] = p2;
        } else if (rank[p1] > rank[p1]) {
          parent[p2] = p1;
        } else {
          parent[p1] = p2;
          rank[p2]++;
        }
      } else {
        return "Yes";
      }
    }

    return "No";
  }

}

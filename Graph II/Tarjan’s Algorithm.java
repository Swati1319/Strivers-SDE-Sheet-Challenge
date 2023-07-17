//Strongly Connected Components (Tarjan’s Algorithm)


import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // This stores our graph as Adjacency list
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < edges.length; i++)
        {
            graph[edges[i][0]].add(edges[i][1]);
        }

        discoveryTime = 1;

        // Arrays to store the low-link value and discovery time of the nodes
        int disc[] = new int[n];
        Arrays.fill(disc, -1);
        int low[] = new int[n];
        Arrays.fill(low, -1);

        Stack<Integer> nodeStack = new Stack();
        boolean inStack[] = new boolean[n];

        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < n; i++)
        {
            if (disc[i] == -1)
            {
                // Node 'i' has not been visited.
                dfs(graph, i, disc, low, inStack, nodeStack, ans);
            }
        }

        // Return the final answer
        return ans;

    }

    // This marks the discovery time of the nodes
    private static int discoveryTime = 1;

    // DFS to visit all the nodes in linear time
    public static void dfs(ArrayList<Integer> graph[], int node, int disc[], int low[], boolean inStack[], Stack<Integer> nodeStack, List<List<Integer>> ans)
    {
        disc[node] = discoveryTime;
        low[node] = discoveryTime;

        ++discoveryTime;

        nodeStack.push(node);
        inStack[node] = true;

        // Using Tarjan's algorithm here
        for (int i = 0; i < graph[node].size(); i++)
        {
            int v = graph[node].get(i);
            // Visiting all unvisited nodes
            if (disc[v] == -1)
            {
                dfs(graph, v, disc, low, inStack, nodeStack, ans);

                low[node] = Math.min(low[node], low[v]);
            }
            else if (inStack[v])
            {
                low[node] = Math.min(low[node], disc[v]);
            }
        }

        // If current node is root of a SCC
        if (low[node] == disc[node])
        {
            // component stores one of the possible SCCs
            List<Integer> component = new ArrayList();
            int u;
            int top = (int) nodeStack.peek();
            while (top != node)
            {
                u = nodeStack.peek();
                nodeStack.pop();
                inStack[u] = false;

                component.add(u);
                top = (int) nodeStack.peek();
            }

            u = nodeStack.peek();

            nodeStack.pop();
            inStack[u] = false;
            component.add(u);
            // Inserting the current SCC into the answer
            ans.add(component);
        }
    }

}

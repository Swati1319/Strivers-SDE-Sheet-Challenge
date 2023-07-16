import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Graph {
    private static int noOfNodes;

    // Pointer to an array containing adjacency lists.
    private static ArrayList < Integer > adj[];

    // Act as Constructor.
    Graph(int noOfNodes) {
        adj = new ArrayList[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            adj[i] = new ArrayList < Integer > ();
        }

        this.noOfNodes = noOfNodes;
    }

    // To add an edge to between two nodes in a Graph.
    public void addEdge(int a, int b) {
        // Add b to a's list.
        adj[a].add(b);
    }

    // Returns true if there exists a cycle in the given graph.
    public static boolean checkCyclic() {
        /* 
            Create a ArrayList to store indegrees 
            (number of incoming edges) 
            of all vertices and initialize all indegrees as 0. 
        */
        ArrayList < Integer > inDegree = new ArrayList < Integer > (noOfNodes);

        for (int i = 0; i < noOfNodes; i++) {
            inDegree.add(0);
        }

        // Traverse adjacency lists to fill indegrees of vertices.
        for (int u = 0; u < noOfNodes; u++) {
            for (int v: adj[u]) {
                inDegree.set(v, inDegree.get(v) + 1);
            }
        }

        // Create an queue and enqueue all vertices with indegree 0.
        Queue < Integer > zeroInDegreeQ = new LinkedList < Integer > ();

        for (int i = 0; i < noOfNodes; i++) {
            if (inDegree.get(i) == 0) {
                zeroInDegreeQ.add(i);
            }
        }

        // Initialize count of visited nodes.
        int cnt = 0;

        /* 
            One by one dequeue vertices from queue and 
            enqueue adjacents if indegree of adjacent becomes 0.
        */
        while (zeroInDegreeQ.isEmpty() == false) {
            // Extract front of queue and add it to topological order.
            int u = zeroInDegreeQ.remove();

            /*
                Iterate through all its neighbouring nodes of 
                dequeued node and decrease their number 
                of incoming edges by 1.
            */

            for (int itr: adj[u]) {
                inDegree.set(itr, inDegree.get(itr) - 1);

                /* 
                    If the number of incoming edges becomes zero 
                    then add it to the queue.
                */
                if (inDegree.get(itr) == 0) {
                    zeroInDegreeQ.add(itr);
                }
            }

            cnt++;
        }

        // Check if there exists a cycle.
        if (cnt != noOfNodes) {
            return true;
        } else {
            return false;
        }
    }
}

public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        Graph directedG = new Graph(n);

        int m = edges.size();

        for (int i = 0; i < m; i++) {
            directedG.addEdge(edges.get(i).get(0) - 1, edges.get(i).get(1) - 1);
        }

        return directedG.checkCyclic();
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair 
{
    int first, second;
    
    Pair(int first, int second) 
    {
        this.first = first;
        this.second = second;
    }
}

class PqComparator implements Comparator<Pair> 
{
    public int compare(Pair p1, Pair p2) 
    {
        if (p1.first < p2.first) 
        {
            return -1;
        }
        return 1;
    }
}

public class Solution 
{
    
    private static ArrayList<ArrayList<Integer>> primsMST(ArrayList<Pair>[] adjList, int n) 
    {
        // Min priority queue.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new PqComparator());

        // Taking source vertex as 0.
        int src = 0;

        // Create vector for key and intilize as infinte.
        ArrayList<Integer> weight = new ArrayList<Integer>(n);

        // To store parent arr.
        ArrayList<Integer> parent = new ArrayList<Integer>(n);

        // To keep track of vertices which allready has been included in mst.
        ArrayList<Boolean> inMST = new ArrayList<Boolean>(n);

        for (int i = 0; i < n; i++) 
        {
            weight.add( Integer.MAX_VALUE);
            parent.add( -1);
            inMST.add( false);
        }

        // Insert source as in priority queue and initialize with 0.
        inMST.set(src, true);

        // 0 weight for current source.
        pq.add(new Pair(0, src));

        // Weight from source to source.
        weight.set(src, 0);

        while (!pq.isEmpty()) 
        {
         
            // The first vertex int pair is the minimum weight vertex ,extract it from priority queue and node name is stored at the second of pair( it has to be done this way to keep the vertices sorted order with respect weight) weight must be first item in pair.
            int u = pq.remove().second;

            // Include u to in our MST.
            inMST.set(u, true);

            // Explore all adjacent of u and if not visited the relax them.
            for (Pair x : adjList[u]) 
            {
                int v = x.first;
                int wt = x.second;

                // If v is not in mst and weight of (u,v) is smaller then the current weight of v.
                if (!inMST.get(v) && weight.get(v) > wt) 
                {
                    // Update weight of v.
                    weight.set(v, wt);

                    // Insert it into the priority queue.
                    pq.add(new Pair(weight.get(v), v));

                    parent.set(v, u);
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < n; i++) 
        {
            result.add(new ArrayList<Integer>());

            result.get(i - 1).add(parent.get(i) + 1);
            result.get(i - 1).add(i + 1);
            result.get(i - 1).add(weight.get(i));
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) 
    {
        ArrayList<Pair> []graph = new ArrayList[n];

        for (int i = 0; i < n; i++) 
        {
            graph[i] = new ArrayList<Pair>();
        }


        for (int i = 0; i < m; i++) 
        {
            graph[g.get(i).get(0) - 1].add(new Pair(g.get(i).get(1) - 1, g.get(i).get(2)));
            graph[g.get(i).get(1) - 1].add(new Pair(g.get(i).get(0) - 1, g.get(i).get(2)));
        }

        return primsMST(graph, n);
    }
}

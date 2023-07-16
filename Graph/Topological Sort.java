

import java.util.*;
import java.io.*;

public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++) 
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0 ; i<edges.size() ; i++)
        {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        // Calculaing indegree of each vertex
        int [] indegree = new int[v];
        for (int i = 0; i < v; i++) 
        {
            ArrayList<Integer> temp = (ArrayList<Integer>)adj.get(i);
            for (int node : temp) 
            {
                indegree[node]++;
            }
        }
        
        // Push all vertices of indegree 0 in queue
        Queue<Integer> que= new LinkedList<Integer>();
        for(int i = 0; i < v; i++) 
        {
            if(indegree[i] == 0) 
            {
               que.add(i);
            }
        }
        
        // It will store topological sort of the given graph
        ArrayList<Integer> result = new ArrayList<>();
    
        // Finding topologial sorting
        while(!que.isEmpty()) 
        {
            int src = que.poll();
            result.add(src);
        
            for(int node : adj.get(src)) 
            {
               indegree[node]--;
               if(indegree[node] == 0) 
                {
                   que.add(node);
                }
            }
        }
        
        return result;
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
   
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

    // Create an array to store the distances from source.
     int [] d=new int[n + 1];

     Arrays.fill(d,1000000000);


	// Distance of source to source is 0.
	d[src] = 0;

	// Apply bellmonford algorithm.
	for (int i = 1; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			int u = edges.get(j).get(0);
			int v =  edges.get(j).get(1);
			int w =  edges.get(j).get(2);

			if (d[u] != 1000000000 && d[v] > (d[u] + w)) {
				d[v] = d[u] + w;
			}
		}
	}

	// Return the distance of destination.
	return d[dest];
    }


}

import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[2];
		TrieNode()
		{
            for (int i = 0; i < 2; i++)
                children[i] = null;
        }
	};

	static TrieNode root;

	static void insert(int num)
	{
		TrieNode ptr = root;
			
		for(int i = 30; i >= 0; i--)
		{
			if((num & (1 << i)) > 0)
			{
				if(ptr.children[1] == null)
				{
					ptr.children[1] = new TrieNode();
				}
				ptr = ptr.children[1];
			}
			else {
				if(ptr.children[0] == null)
				{
					ptr.children[0] = new TrieNode();
				}
				ptr = ptr.children[0];
			}
		}
	}

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> queries)
    {

		//  Size of array and number of queries.
		int n = arr.size();
		int m = queries.size();
		
		ArrayList<Integer> result = new ArrayList<Integer>(m);
		ArrayList<Integer> order = new ArrayList<Integer>(m);
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(m);
		for(int i = 0; i < m; i++)
		{
			result.add(-1);
			order.add(i);
		}
		for(int i = 0; i < m; i++)
		{
			ArrayList<Integer> local = new ArrayList<Integer>();
			local.add(queries.get(i).get(1));
			local.add(order.get(i));
			temp.add(local);
		}
		
		//  Sort arr in non-decreasing order.
		Collections.sort(arr);
	
		//  Order in which queries will be processed.
		Collections.sort(temp,new java.util.Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b)
            {
                return Integer.compare(a.get(0) , b.get(0));
            }
        });

		for(int i = 0; i < m; i++)
		{
			order.set(i,temp.get(i).get(1));
		}

		root = new TrieNode();
		int p = 0;
	
		// Finding answer of each query.
		for(int i = 0; i < m; i++)
		{

			// Index of query process in current iteration.
			int id = order.get(i);
	
			// Insert integers of 'arr' smaller or equal to queries[id][1] in trie.
			while(p < n && arr.get(p) <= queries.get(id).get(1))
			{
				insert(arr.get(p));
				p++;
			}
	
			// If trie is empty then answer to this query is -1.
			if(root.children[0] == null && root.children[1] == null)
			{
				continue;
			}
	
			TrieNode ptr = root;
			int ans = 0;
	
			for(int j = 30; j >= 0; j--) 
			{

				// If jth bit is set in query[id][0].
				if((queries.get(id).get(0) & (1 << j)) > 0)
				{
					if(ptr.children[0] != null)
					{
						ptr = ptr.children[0];
						ans = ans | (1 << j);
					}
					else
					{
						ptr = ptr.children[1];
					}
	
				}
				else
				{

					// If jth bit is not set in query[id][0].
					if(ptr.children[1] != null)
					{
						ptr = ptr.children[1];
						ans = ans | (1 << j);
					}
					else
					{
						ptr = ptr.children[0];
					}
				}
			}
				
			result.set(id, ans);
		}
		return result;
    }

}

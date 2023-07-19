import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) 
    {	
        int n = arr.size();
		
        // Create an array to store all subsets
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
        for (int i = 0; i < Math.pow(2, n); i++) 
        {	
            ArrayList<Integer> temp = new ArrayList<>();
			
            // Traverse through the array ARR
            for (int j = 0; j < n; j++) 
            {	
                // Check if j-th bit is set
				if ((i & (1 << j)) > 0) 
                {
					temp.add(arr.get(j));
				}
			}
            
            // Insert the subset temp in ans
			ans.add(temp);
		}
		
        // Return the array ans
		return ans;
	}
}

import java.util.ArrayList;

public class Solution
{
    public static int countRow(ArrayList<Integer> row,int n)
    {
        int low = 0;
        int high = row.size()-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(row.get(mid)<=n)    low = mid+1;
            else                   high = mid-1;
        }
        
        return low;
        
    }
    public static int countElements(ArrayList<ArrayList<Integer>> matrix,int num)
    {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        int total = 0;
        
        for(int i=0 ; i<m ; ++i){
            total+=countRow(matrix.get(i),num);
        }
        
        return total;
    }
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        int m = matrix.size();
        int n = matrix.get(0).size();
        int low = 1;
        int high = (int)1e5;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(countElements(matrix,mid)<= (m*n)/2)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return low;
	}
}

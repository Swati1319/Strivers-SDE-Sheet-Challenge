import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        
        //  Size of array/list 'price'.
    	int n = price.size();

    	//  Make an array/list 'result' of size 'n' and fill it with 0.
    	ArrayList<Integer> result = new ArrayList<>();
    	for(int i=0; i<n; i++) {
    		result.add(0);
    	}

    	Stack<Integer> stk = new Stack<Integer>();

    	for(int i = 0; i < n; i++) {
        	
        	//  Stack will have only those days before 'i' in which price is higher than price at day 'i'.
        	while(stk.isEmpty() == false && price.get(stk.peek()) <= price.get(i)) {	
        		stk.pop();
	        }

	        //  Span on day 'i'.
	        if(stk.isEmpty() == true) {
            	result.set(i, i + 1);
            }
            else {
            	result.set(i, i - stk.peek());
            }
            stk.push(i);
        }
    	return result;    	
    }
}

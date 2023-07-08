public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
		int cnt = 0;
		for(int i = 0 ; i <= n-m ; i++) {
			String sub = s.substring(i,i+m);
			if(sub.equalsIgnoreCase(p)) { cnt++;}
		}
		return cnt;

	}

}

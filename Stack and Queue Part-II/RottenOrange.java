import java.util.*;
public class Solution {

    public static int minTimeToRot(int[][] grid, int n, int m) {

        Queue<Pair> q=new LinkedList<Pair>();

        int t=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){

                    q.add(new Pair(i,j,0));

                }
            }
        }
        int[] delRow=new int[]{-1,0,1,0};
        int[] delCol=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int time=q.peek().time;
            q.remove();
            t= Math.max(time, t);
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && grid[nRow][nCol]!=2){
                    q.add(new Pair(nRow,nCol, time+1));
                    grid[nRow][nCol]=2;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){

                    return -1;

                }
            }
        }
        return t;
    }

}

    class Pair{
        int first;
        int second;
        int time;

        public Pair(int first,int second,int time){

            this.first=first;

            this.second=second;

            this.time=time;

        }

    }

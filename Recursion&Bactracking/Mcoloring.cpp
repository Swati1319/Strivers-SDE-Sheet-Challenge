bool ispossible(int node, vector<vector<int>> &mat,int i,vector<int>&col)
{
    for(int j=0;j<mat.size();j++)
    if(mat[node][j]==1 && col[j]==i)
    return false;  //adjacent with color i so node color i te rongin hobe na.

    return true;
}
bool solve(int node,vector<vector<int>> &mat,vector<int>&col,int m,int n)
{
    if(node==n)//means we have colored every node
    return true;

    for(int i=1; i<=m; i++) //try to color with every color
    {

      if (ispossible(node, mat, i, col)) {
        col[node] = i;
        if (solve(node + 1, mat, col, m, n)) // ekbar true pele barbar true
          return true;
        col[node] = 0;
      }
    }
    return false;  //false ta niche ar true ta age mane ami try korchi ture ta peye gelei jate return hoye jay
    //ar kichu dekhar dorkar nei.
}

string graphColoring(vector<vector<int>> &mat, int m) {
    // Write your code her
    int n = mat.size();
    
    vector<int> col(n,0);
    int node =0;
    if(solve(node,mat,col,m,n))
    return "YES";

    return "NO";

}

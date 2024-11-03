/**
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 *
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
 * grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 * image.png
 * */

class Solution {
  boolean res;
  public boolean isSafe(int x, int y, int[][] grid1, int[][] grid2, int n, int m) {
    if(x>=n || y>=m || x<0 || y<0 || grid2[x][y]==0)
      return false;
    return true;
  }
  public boolean solve(int x, int y, int[][] grid1, int[][] grid2, int n, int m) {
    if(!isSafe(x,y,grid1,grid2,n,m)) {
      return false;
    }
    if(grid1[x][y]==0 && grid2[x][y]==1) {
      res=false;
    }
    grid2[x][y]=0;
    solve(x+1,y,grid1,grid2,n,m);
    solve(x-1,y,grid1,grid2,n,m);
    solve(x,y+1,grid1,grid2,n,m);
    solve(x,y-1,grid1,grid2,n,m);
    return true;
  }
  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int i,j,n=grid1.length,m;
    m=grid1[0].length;
    int ans=0;
    for(i=0;i<n;i++) {
      for(j=0;j<m;j++) {
        if(grid2[i][j]==1) {
          res=true;
          solve(i,j,grid1,grid2,n,m);
          if(res) {
            ans++;
          }
        }
      }
    }
    return ans;
  }
}
/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 *
 * Asked in Facebook, Google, Amazon
 * */

class Solution {
  public boolean isSafe(int x, int y, int n, int m) {
    if(x<0 || x>=n || y<0 || y>=m)
      return false;
    return true;
  }
  public boolean checkBoundary(int x, int y, int n, int m) {
    if(x==-1 || x==n || y==-1 || y==m)
      return true;
    return false;
  }
  public int islandPerimeter(int[][] grid) {
    int i,j,n=grid.length, m=grid[0].length;
    int ans=0;
    for(i=0;i<n;i++) {
      for(j=0;j<m;j++) {
        if(grid[i][j]==1) {
          if(isSafe(i+1,j,n,m) && grid[i+1][j]==0) {
            ans=ans+1;
          }
          else if(checkBoundary(i+1,j,n,m))  {
            ans=ans+1;
          }
          if(isSafe(i-1,j,n,m) && grid[i-1][j]==0) {
            ans=ans+1;
          }
          else if(checkBoundary(i-1,j,n,m)) {
            ans=ans+1;
          }
          if(isSafe(i,j+1,n,m) && grid[i][j+1]==0) {
            ans=ans+1;
          }
          else if(checkBoundary(i,j+1,n,m)) {
            ans=ans+1;
          }
          if(isSafe(i,j-1,n,m) && grid[i][j-1]==0) {
            ans=ans+1;
          }
          else if(checkBoundary(i,j-1,n,m)) {
            ans=ans+1;
          }
        }
      }
    }
    return ans;
  }
}
/**
 * Problem statement
 * You are given a matrix having ‘N’ rows and ‘M’ columns. Each cell of the matrix can only contain three values as given below:
 *
 * -1 -> It denotes a wall or an obstacle
 *
 * 0  -> It denotes a gate
 *
 * 2^31 - 1 =  2147483647 ( INF ) -> An infinitely large value  denotes the empty room.
 *
 * For each empty room (denoted by INF), you have to refill it with the distance to its nearest gate. If none of the gates is reachable from an empty room then the value ‘INF’ will remain as it is.
 * Example
 * For the matrix [[0,-1],[0,2147483647]] the updated matrix will be [[0,-1],[0,1]].
 * Note
 * The distance between two cells having their coordinates (x1,y1) and (x2,y2) are abs(x2-x1) + abs(y2-y1).
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 10^4
 * 1 <= M <= 10^4
 * 1 <= N*M <= 10^4
 *
 *
 * Sample Input 1:
 *
 * 2
 * 2 2
 * 2147483647 -1
 * -1 0
 * 4 4
 * 2147483647 -1 0 2147483647
 * 2147483647 2147483647 2147483647 -1
 * 2147483647 -1 2147483647 -1
 * 0 -1 2147483647 2147483647
 *
 *
 * Sample Output 1:
 * 2147483647 -1
 * -1 0
 * 3 -1 0 1
 * 2 2 1 -1
 * 1 -1 2 -1
 * 0 -1 3 4
 * */

// This solution is using DFS

import java.util.* ;
import java.io.*;
import javafx.util.Pair;
import java.util.ArrayList;
public class Solution {
  public static void solve(int x, int y, int [][] a, int ans) {
    if(x<0 || x>=a.length || y<0 || y>=a[0].length || a[x][y]<ans) {
      return ;
    }
    a[x][y]=ans;
    solve(x+1,y,a,ans+1);
    solve(x-1,y,a,ans+1);
    solve(x,y+1,a,ans+1);
    solve(x,y-1,a,ans+1);
    return ;
  }
  public static int[][] wallsAndGates(int[][] a, int n, int m) {
    // Write you code here
    int i,j;
    for(i=0;i<n;i++) {
      for(j=0;j<m;j++) {
        if(a[i][j]==0) {
          solve(i,j,a,0);
        }
      }
    }
    return a;
  }
}

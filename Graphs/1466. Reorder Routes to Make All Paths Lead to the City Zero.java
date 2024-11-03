/***
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 *
 * Constraints:
 *
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 *
 * Asked in DRW, Amazon, American Express, Grab
 */

class Solution {
  public int minReorder(int n, int[][] connections) {
    // Map to restore original connections
    Map<Integer, List<Integer>> map = new HashMap<>();
    int i,j;
    for(i=0;i<n-1;i++) {
      if(map.containsKey(connections[i][0])) {
        List<Integer> a = map.get(connections[i][0]);
        a.add(connections[i][1]);
        map.put(connections[i][0], a);
      }
      else {
        List<Integer> a = new ArrayList<>();
        a.add(connections[i][1]);
        map.put(connections[i][0], a);
      }
    }
    // make bidirectional
    List<List<Integer>> adj = new ArrayList<>();
    for(i=0;i<n;i++) {
      adj.add(new ArrayList<>());
    }
    for(i=0;i<n-1;i++) {
      int x = connections[i][0];
      int y = connections[i][1];
      adj.get(x).add(y);
      adj.get(y).add(x);
    }
    boolean vis[] = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    int change=0;
    while(!q.isEmpty()) {
      int par = q.poll();
      vis[par]=true;
      List<Integer> child = adj.get(par);
      for(i=0;i<child.size();i++) {
        int c=child.get(i);
        if(vis[c]==false && map.containsKey(par)) {
          List<Integer> conn = map.get(par);
          for(j=0;j<conn.size();j++) {
            if(conn.get(j)==c) {
              change++;
            }
          }
        }
        if(!vis[c])
          q.add(c);
      }
    }
    return change;
  }
}
/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 * Asked in Facebook, Amazon, Apple
 * */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int ans=0;
  public void solve(TreeNode root, int low, int high) {
    if(root==null)
      return ;
    if(low<=root.val && root.val<=high)
      ans=ans+root.val;
    if(root.val<low) {
      solve(root.right, low, high);
    }
    else if(root.val>high) {
      solve(root.left, low, high);
    }
    else {
      solve(root.left, low, high);
      solve(root.right, low, high);
    }
  }
  public int rangeSumBST(TreeNode root, int low, int high) {
    solve(root, low, high);
    return ans;
  }
}

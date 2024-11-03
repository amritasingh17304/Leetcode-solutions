/**
 * You are given the root of a full binary tree with the following properties:
 *
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
 * Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
 * The evaluation of a node is as follows:
 *
 * If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
 * Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
 * Return the boolean result of evaluating the root node.
 *
 * A full binary tree is a binary tree where each node has either 0 or 2 children.
 *
 * A leaf node is a node that has zero children.
 *
 * Input: root = [2,1,3,null,null,0,1]
 * Output: true
 *
 * Input: root = [0]
 * Output: false
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
  public boolean solve(TreeNode root) {
    if(root.left==null && root.right==null) {
      int data=root.val;
      return data == 1 ? true:false;
    }
    boolean ans1 = solve(root.left);
    boolean ans2 = solve(root.right);
    if(root.val==2) {
      return ans1||ans2;
    }
    else
      return ans1&&ans2;
  }
  public boolean evaluateTree(TreeNode root) {
    // leaf node
    return solve(root);
  }
}
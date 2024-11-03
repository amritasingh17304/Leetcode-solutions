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
/**Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.

    Return the root of the modified tree.
 Input: root = [5,4,9,1,10,null,7]
 Output: [0,0,0,7,7,null,11]

 Approach : 2 BFS technqiues
 Space complexity O(n), Time O(n)
 **/



class Solution {
    Map<Integer, Integer> lev = new TreeMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null)
            return null;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()) {
            int size = q.size();
            int curr_sum=0;
            while(size>0) {
                TreeNode node = q.peek();
                q.poll();
                curr_sum=curr_sum+node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                size--;
            }
            lev.put(level, curr_sum);
            level+=1;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        root.val = 0;
        int l=0;
        while(!queue.isEmpty()) {
            int size=queue.size();
            while(size>0) {
                TreeNode curr = queue.peek();
                queue.poll();
                int siblingSum=0;
                if(curr.left!=null)
                    siblingSum+=curr.left.val;
                if(curr.right!=null)
                    siblingSum+=curr.right.val;
                if(curr.left!=null) {
                    queue.add(curr.left);
                    curr.left.val = lev.get(l+1)-siblingSum;
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                    curr.right.val = lev.get(l+1)-siblingSum;
                }
                size--;
            }
            l++;
        }
        return root;
    }
}
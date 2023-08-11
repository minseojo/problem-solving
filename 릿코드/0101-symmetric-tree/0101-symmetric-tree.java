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

    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        result = travel(root.left, root.right);

        return result;
    }

    boolean travel(TreeNode l, TreeNode r) {

        if(l == null && r == null) {
            System.out.println(-1);
            return true;
        } else if(l == null && r != null || r == null && l != null) return false;
        
        System.out.println(l.val + " " + r.val);
        if(l.val != r.val) return false;
        
        return travel(l.left, r.right) && travel(l.right, r.left);
    }
}
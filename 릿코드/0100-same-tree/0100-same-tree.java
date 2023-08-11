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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        result = travel(p, q);
        return result;
    }

    boolean travel(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        else if(l == null && r != null || r == null && l != null) return false;

        if(l.val != r.val) return false;

        return travel(l.left, r.left) && travel(l.right, r.right);
    }
}
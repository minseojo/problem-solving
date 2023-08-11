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
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return result;

        travel(root, 0);
        return result;
    }

    int travel(TreeNode root, int depth) {
        if(root == null) return depth;

        int leftDepth = depth;
        int rightDepth = depth;
        if(root.left != null) leftDepth = Math.max(leftDepth, travel(root.left, depth+1)); 
        if(root.right != null) rightDepth = Math.max(rightDepth, travel(root.right, depth+1));

        System.out.println(root.val + " " + leftDepth + " " + rightDepth);

        if(Math.abs(leftDepth - rightDepth) > 1) result = false;

        return Math.max(leftDepth, rightDepth);
    }
}
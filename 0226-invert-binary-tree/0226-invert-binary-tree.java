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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode node = new TreeNode(root.val);
        dfs(node, root);
        return node;
    }

    void dfs(TreeNode node, TreeNode root) {
        if (root.right != null) {
            node.left = new TreeNode(root.right.val);
            dfs(node.left, root.right);
        }
        if (root.left != null) {
            node.right = new TreeNode(root.left.val);
            dfs(node.right, root.left);
        }
    }
}
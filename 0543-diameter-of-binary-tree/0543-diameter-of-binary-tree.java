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
    int answer;
    public int diameterOfBinaryTree(TreeNode root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    int dfs(TreeNode root) {        
        int left = 0;
        int right = 0;
        if (root.left != null) left = dfs(root.left) + 1;
        if (root.right != null) right = dfs(root.right) + 1;
        answer = Math.max(answer, left + right);
        return Math.max(left, right);
    }
}
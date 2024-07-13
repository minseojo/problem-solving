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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;

        answer = 0;
        dfs(root, root.val);
        return answer;
    }

    int dfs(TreeNode root, int target) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            if (root.left.val == target) {
                left = dfs(root.left, target) + 1; 
            } else {
                dfs(root.left, root.left.val);
            }
        }
        if (root.right != null) {
            if (root.right.val == target) {
                right = dfs(root.right, target) + 1;
            } else {
                dfs(root.right, root.right.val);
            }
        }
        answer = Math.max(answer, left + right);
        return Math.max(left, right);
    }
}
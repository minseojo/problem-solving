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
    TreeNode prev = null;
    int answer = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        if(prev != null){
            answer = Math.min(answer, root.val-prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
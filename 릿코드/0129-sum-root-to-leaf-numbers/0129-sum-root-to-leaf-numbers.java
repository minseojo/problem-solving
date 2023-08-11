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

    public int sumNumbers(TreeNode root) {
        int result = 0;
        result = travle(root, root.val);
        return result;
    }
    
    public int travle(TreeNode root, int sum) {
        if(root.left == null && root.right == null) return sum;
        int result = 0;
        if(root.left != null) {
            result += travle(root.left, (sum*10) + root.left.val);
        }
        if(root.right != null) {
            result += travle(root.right, (sum*10) + root.right.val);
        }
        return result;
    }
}
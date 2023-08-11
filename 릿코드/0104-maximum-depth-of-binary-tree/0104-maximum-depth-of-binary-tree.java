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
    private int result = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        depthTravel(root, 0);
        return result+1;
    }

    void depthTravel(TreeNode root, int depth) {
        if(root != null) {
            if(root.left != null) depthTravel(root.left, depth+1);
            System.out.println(root.val + " " + depth);
            result = Math.max(result, depth);
            if(root.right != null) depthTravel(root.right, depth+1);
        } 
    }
}
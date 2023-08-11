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
        if(root == null) return null;

        TreeNode invertRoot = new TreeNode(root.val);        
        dfs(invertRoot, root);
        return invertRoot;
    }

    private void dfs(TreeNode invertRoot, TreeNode root) {
        if(root != null) {
            if(root.right != null) dfs(invertRoot.left = new TreeNode(), root.right);
            invertRoot.val = root.val;    
            if(root.left != null) dfs(invertRoot.right = new TreeNode(), root.left);
            
        }
    }
}
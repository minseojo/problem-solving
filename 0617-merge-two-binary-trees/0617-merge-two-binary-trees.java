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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode temp = new TreeNode();
        TreeNode root = temp;
        dfs(temp, root1, root2);
        return root;
    }

    TreeNode dfs(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        if (root1 == null) {
            root.val = root2.val;
            if (root2.left != null) {
                root.left = new TreeNode();
                dfs(root.left, null, root2.left);
            }
            if (root2.right != null) {
                root.right = new TreeNode();
                dfs(root.right, null, root2.right);
            }
        } else if (root2 == null) {
            root.val = root1.val;
            if (root1.left != null) {
                root.left = new TreeNode();
                dfs(root.left, root1.left, null);
            }
            if (root1.right != null) {
                root.right = new TreeNode();
                dfs(root.right, root1.right, null);
            }
        } else {
            root.val = root1.val + root2.val;
            if (root1.left != null || root2.left != null) {
                root.left = new TreeNode();
                dfs(root.left, root1.left, root2.left);
            }
            if (root1.right != null || root2.right != null) {
                root.right = new TreeNode();
                dfs(root.right, root1.right, root2.right);
            }
        }

        return root;
    }
}
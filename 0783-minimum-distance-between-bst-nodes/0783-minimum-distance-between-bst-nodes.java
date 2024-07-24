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

    List<Integer> nodes = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;

        inorder(root);

        Collections.sort(nodes);
        for (int i = 0; i < nodes.size() - 1; i++) {
            result = Math.min(result, nodes.get(i + 1) - nodes.get(i));
        }
        return result;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
}
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, Map<Integer, Integer> map, int here, int left, int right) {
        int mid = map.get(preorder[here]);
        TreeNode root = new TreeNode(preorder[here]);

        if (left < mid) {
            root.left = build(preorder, map, here + 1, left, mid - 1);
        }
        if (right > mid) {
            root.right = build(preorder, map, here + mid - left + 1, mid + 1, right);
        }

        return root;
    }
}
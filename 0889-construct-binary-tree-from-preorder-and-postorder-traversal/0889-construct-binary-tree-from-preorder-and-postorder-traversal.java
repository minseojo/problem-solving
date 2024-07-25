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

    int preIdx;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return construct(preorder, map, 0, postorder.length - 1);
    }

    TreeNode construct(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        if (left == right) return root;

        int mid = map.get(preorder[preIdx]);

        root.left = construct(preorder, map, left, mid);
        root.right = construct(preorder, map, mid + 1, right - 1);
        return root;

    }
}
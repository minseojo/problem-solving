class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, map, postorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode build(int[] postorder, Map<Integer, Integer> map, int postIdx, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(postorder[postIdx]);
        int mid = map.get(postorder[postIdx]);

        root.left = build(postorder, map, postIdx - (right - mid) - 1, left, mid - 1);
        root.right = build(postorder, map, postIdx - 1, mid + 1, right);
        return root;
    }
}
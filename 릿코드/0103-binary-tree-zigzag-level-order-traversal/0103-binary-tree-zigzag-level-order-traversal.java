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
    int level = 0;
    List<List<Integer>> levelList = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return result;

        countLevel(root, 0);
        for(int i=0; i<=level; i++) {
            result.add(new LinkedList<Integer>());
            levelList.add(new LinkedList<Integer>());
        }

        dfs(root, 0);
        for(int i=0; i<levelList.size(); i++) {
            if(i%2==0) {
                for(int j=0; j<levelList.get(i).size(); j++) {
                    result.get(i).add(levelList.get(i).get(j));
                }
            } else if(i%2==1){
                for(int j=levelList.get(i).size()-1; j>=0; j--) {
                    result.get(i).add(levelList.get(i).get(j));
                }
            }
        }
        return result;
    }

    public void countLevel (TreeNode root, int depth) {
        level = Math.max(level, depth);
        if(root != null) {
            if(root.left != null) countLevel(root.left, depth+1);
            if(root.right != null) countLevel(root.right, depth+1);
        }
    }

    public void dfs(TreeNode root, int depth) {
        if(root != null) {
            levelList.get(depth).add(root.val);
            if(root.left != null) dfs(root.left, depth+1);
            if(root.right != null) dfs(root.right, depth+1);
        }
    }
}
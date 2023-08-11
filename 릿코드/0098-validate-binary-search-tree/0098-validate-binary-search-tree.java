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

/*

    public TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root!=null){
            if(!isValidBST(root.left)) return false;

            if(prev!=null && root.val<=prev.val) return false;

            prev=root;
            return isValidBST(root.right);
        }
        return true;
        
    }
*/


class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        travel(root);
        for(int i=0; i<list.size()-1; i++) {
            System.out.println(list.get(i) + " " + list.get(i+1));
            if(list.get(i) >= list.get(i+1)) return false;
        }
        return true;
    }

    void travel(TreeNode root) {       
        if(root.left != null) travel(root.left);
        list.add(root.val);
        if(root.right != null) travel(root.right);
    }
}
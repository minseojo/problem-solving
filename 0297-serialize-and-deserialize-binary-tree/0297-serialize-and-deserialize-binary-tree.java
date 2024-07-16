/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        sb.append(String.valueOf("#," + root.val)); // 0번 인덱스 사용 X
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
                sb.append("," + cur.left.val);
            } else {
                sb.append(",#");
            }
            if (cur.right != null) {
                q.add(cur.right);
                sb.append("," + cur.right.val);
            } else {
                sb.append(",#");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) return null;
        
        TreeNode root = new TreeNode();
        TreeNode temp = root;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        root.val = Integer.parseInt(nodes[1]);
        int index = 1;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            index++;
            if (!nodes[index].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.left);
            }
            index++;
             if (!nodes[index].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.right);
            }
        }

        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
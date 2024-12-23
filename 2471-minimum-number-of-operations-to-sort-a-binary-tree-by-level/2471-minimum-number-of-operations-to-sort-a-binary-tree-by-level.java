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

    public int minimumOperations(TreeNode root) {
        return bfs(root);
    }
    
    public int bfs(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode front = q.poll();
                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            // 스왑 횟수 더하기
            if (q.isEmpty()) break;

            int[] arr = new int[q.size()];
            int k = 0;
            for (TreeNode data : q) {
                arr[k++] = data.val;
            }
            int[] sortedArr = arr.clone();
            Arrays.sort(sortedArr);

            for (int i = 0; i < q.size(); i++) {
                if (arr[i] != sortedArr[i]) {
                    result++;
                    swap(arr, i, findIndex(arr, sortedArr[i]));
                }
            }
        }

        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        
        return -1;
    }

}
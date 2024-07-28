class Solution {
    boolean answer;
    boolean[] visited;
    public boolean canJump(int[] nums) {
        answer = false;
        visited = new boolean[100001];
        dfs(nums, 0);
        return answer;
    }

    boolean dfs(int[] nums, int position) {
        if (position >= nums.length) 
            return false;

        visited[position] = true;
        if (position == nums.length - 1) {
            answer = true;
            return true;
        }
        for (int i = 1; i <= nums[position]; i++) {
            if (position + i <= 100000 && !visited[position + i])
                dfs(nums, position + i);
        }

        return false;
    }
}
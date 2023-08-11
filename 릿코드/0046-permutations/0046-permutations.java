class Solution {
    public ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new int[nums.length], new boolean[nums.length+20]);

        return result;
    }

    public void dfs(int[] nums, int pos, int[] cache, boolean[] visited) {
        if(pos == nums.length) {
            ArrayList list = new ArrayList<Integer>();

            for(int i=0; i<nums.length; i++) {
                list.add(cache[i]);
            }

            result.add(list);
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(visited[nums[i]+10]) continue;
            visited[nums[i]+10] = true;
            cache[pos] = nums[i];
            dfs(nums, pos+1, cache, visited);
            visited[nums[i]+10] = false;
        }
    }
}
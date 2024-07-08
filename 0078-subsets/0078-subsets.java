class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, new ArrayList<>(), new boolean[nums.length] ,nums, results);
        return results;
    }

    void dfs(int index, List<Integer> cache, boolean[] isCache, int[] nums, List<List<Integer>> results) {
        results.add(new ArrayList<>(cache));
        for (int i = index; i < nums.length; i++) {
            if (isCache[i]) continue;
            isCache[i] = true;
            cache.add(nums[i]);
            dfs(i + 1, cache, isCache, nums, results);
            isCache[i] = false;
            cache.removeLast();
        }
    }
}
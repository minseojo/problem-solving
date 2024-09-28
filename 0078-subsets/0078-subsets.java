class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, results);
        return results;
    }

    void dfs(int index, List<Integer> cache, int[] nums, List<List<Integer>> results) {
        results.add(new ArrayList<>(cache));
        for (int i = index; i < nums.length; i++) {
            cache.add(nums[i]);
            dfs(i + 1, cache, nums, results);
            cache.removeLast();
        }
    }
}
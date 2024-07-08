class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), new boolean[nums.length], nums, result);
        return result;
    }

    void dfs (int pos, List<Integer> cache, boolean[] isCache, int[] nums, List<List<Integer>> result) {
        if (pos == nums.length) {
            result.add(new ArrayList<>(cache));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isCache[i]) continue;
            isCache[i] = true;
            cache.add(nums[i]);
            dfs(pos + 1, cache, isCache, nums, result);
            cache.remove(cache.size() - 1);
            isCache[i] = false;
        }
    }
}
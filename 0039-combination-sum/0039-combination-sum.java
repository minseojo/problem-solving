class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, target, new ArrayList<>(), candidates, results);
        return results;
    }

    void dfs(int here, int sum, List<Integer> cache, int[] candidates, List<List<Integer>> results) {
        if (sum == 0) {
            results.add(new ArrayList<>(cache));
            return;
        }

        for (int i = here; i < candidates.length; i++) {
            int c = candidates[i];

            if (sum - c >= 0) {
                cache.add(c);
                dfs(i, sum - c, cache, candidates, results);
                cache.remove(cache.size() - 1);
            }
        }
    }
}
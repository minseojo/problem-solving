class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, 1, new ArrayList<>(), n, k, results);
        return results;
    }

    void dfs(int pos, int index, List<Integer> cache, int n, int k, List<List<Integer>> results) {
        if (pos == k) {
            results.add(new ArrayList<>(cache));
            return;
        }

        for (int i = index;  i <= n; i++) {
            cache.add(i);
            dfs(pos + 1, i + 1, cache, n, k, results);
            cache.remove(cache.size() - 1);
        }
    }
}
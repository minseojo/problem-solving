class Solution {
    public ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 0, new int[k], 1);
        
        return result;
    }

    public void dfs(int n, int k, int pos, int[] cache, int index) {
        if(pos == k) {
            ArrayList list = new ArrayList<Integer>();
            for(int i=0; i<k; i++) {
                list.add(cache[i]);
            }
            result.add(list);
            return;
        }
        
        for(int i=index; i<=n; i++) {
            cache[pos] = i;
            dfs(n, k, pos+1, cache, i+1);
            cache[pos] = 0;
        }
    }
}
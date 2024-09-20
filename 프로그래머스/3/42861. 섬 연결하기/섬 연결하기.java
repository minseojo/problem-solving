import java.util.*;

class Solution {
    
    int[] parent = new int[100];
    
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    void merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) parent[u] = parent[v];
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] c : costs) {
            int u = c[0];
            int v = c[1];
            int cost = c[2];
            
            if (find(u) != find(v)) {
                merge(u, v);
                answer += cost;
            }
        }
        
        return answer;
    }
}
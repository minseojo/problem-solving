import java.util.*;

class Solution {
    
    private int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    // 다리 연결 (정점 인덱스 작은게 부모)
    private void merge(int u, int v, int[] parent) {
        u = find(u, parent);
        v = find(v, parent);
        if (u < v) parent[v] = u;
        else parent[u] = v;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> Integer.compare(i[2], j[2]));
        for (int[] cost: costs) {
            pq.add(new int[] {cost[0], cost[1], cost[2]});
        }
        
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] cost = pq.poll();
            int u = cost[0];
            int v = cost[1];
            int c = cost[2];
            if (find(u, parent) != find(v, parent)) {
                merge(u, v, parent);
                sum += c;
            }
        }
        
        answer = sum;
        return answer;
    }
}
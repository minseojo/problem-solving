import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            if (source == destination) answer[i] = 0;
            else answer[i] = dijkstra(n, graph, source, destination);
        }
        
        return answer;
    }
    
    public int dijkstra(int n, List<Integer>[] graph, int source, int destination) {
        int result = 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 500001);
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[] {source, 0});
        dist[source] = 0;
        
        while (!pq.isEmpty()) {
            int size = pq.size();
            while (size-- > 0) {
                int[] cur = pq.poll();
                int curNode = cur[0];
                int curCost = cur[1];
            
                if (dist[curNode] < curCost) continue;
                
                for (int next : graph[curNode]) {
                    int nextNode = next;
                    int nextCost = 1;
                    
                    if (dist[nextNode] > curCost + nextCost) {
                        dist[nextNode] = curCost + nextCost;
                        if (nextNode == destination) return result + 1;
                        pq.add(new int[] {nextNode, dist[nextNode]});
                    }
                }
            }
            result++;
        }
        
        return -1;
    }
}
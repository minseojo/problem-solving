import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<List<Integer>> roadList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            roadList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            roadList.get(u).add(v);
            roadList.get(v).add(u);
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dijkstra(n, roadList, sources[i], destination);
        }
        return answer;
    }
    
    private int dijkstra(int n, List<List<Integer>> roads, int departure, int destination) {
        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int INF = 10000000;
        for (int i = 0; i <= n; i++) {
            cost[i] = INF;
        }
        q.add(departure);
        cost[departure] = 0;
        visited[departure] = true;
        
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == destination) break;

                for (int i = 0; i < roads.get(cur).size(); i++) {
                    int next = roads.get(cur).get(i);
                    if (visited[next]) continue;
                    if (next == destination) return count;
                    cost[next] = count;
                    visited[next] = true;
                    q.add(next);
                }
            }
            count++;
        }
        
        if (cost[destination] == INF) return -1;
        else return cost[destination];
    }
}
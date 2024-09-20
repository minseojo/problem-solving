import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        visited[1] = true;

        int last = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            last = size;
            while (size-- > 0) {
                int cur = q.poll();
                for (int i = 0; i < graph.get(cur).size(); i++) {
                    int next = graph.get(cur).get(i);
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return last;
    }
}
import java.util.*;

class Solution {
    
    int a, b, c;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
        
        for (int[] w : wires) {
            Integer u = w[0];
            Integer v = w[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        for (int[] w : wires) {
            Integer u = w[0];
            Integer v = w[1];
            tree.get(u).remove(v);
            tree.get(v).remove(u);
            
            boolean[] visited = new boolean[n + 1];
            a = 0; b = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(tree, i, visited);
                    break;
                }
            }
            c = 1;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(tree, i, visited);
                    break;
                }
            }
            c = 0;

            answer = Math.min(answer, Math.abs(a - b));
            
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        return answer;
    }
    
    void dfs(Map<Integer, List<Integer>> graph, int here, boolean[] visited) {
        visited[here] = true;
        
        if (c == 0) a++;
        else b++;
        for (int i = 0; i < graph.get(here).size(); i++) {
            int next = graph.get(here).get(i);
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
        
    }
}
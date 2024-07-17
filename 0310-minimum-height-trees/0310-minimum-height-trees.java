class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> answer = new ArrayList<>();

        if (n == 1) {
            answer.add(0);
            return answer;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                visited[i] = true;
                q.add(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int cur = q.poll();
                for (int i = 0; i < graph.get(cur).size(); i++) {
                    int next = graph.get(cur).get(i);
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            answer.add(q.poll());
        }

        return answer;
    }
}
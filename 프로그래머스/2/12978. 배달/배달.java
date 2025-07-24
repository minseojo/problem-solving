import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1]; // [to, cost]
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int u = r[0], v = r[1], c = r[2];
            graph[u].add(new int[]{v, c});
            graph[v].add(new int[]{u, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currNode = cur[0];
            int currDist = cur[1];

            if (dist[currNode] < currDist) continue;

            for (int[] edge : graph[currNode]) {
                int neighbor = edge[0];
                int edgeCost = edge[1];

                if (dist[neighbor] > currDist + edgeCost) {
                    dist[neighbor] = currDist + edgeCost;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }

        int answer = 0;
        for (int d : dist) {
            if (d <= K) answer++;
        }
        return answer;
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static final long INF = (long) (1e14 + 1e3);

    static int n, m;
    static List<int[]>[] graph;

    static class Edge {
        int to;
        long weight;
        long maxWeight;

        public Edge(int to, long weight, long maxWeight) {
            this.to = to;
            this.weight = weight;
            this.maxWeight = maxWeight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, cost});
            graph[v].add(new int[] {u, cost});
        }

        long answer = INF;

        long left = 1;
        long right = c;
        while (left <= right) {
            long mid = (left + right) / 2; // maximumMoney

            long[] dist = new long[n + 1];
            if (dijkstra(a, b, mid, dist) && dist[b] <= c) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }

    static boolean dijkstra(int start, int destination, long maximumMoney, long[] dist) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>((q1, q2) -> Long.compare(q1.weight, q2.weight));
        q.add(new Edge(start, 0, 0));

        // [노드][비용] = 최대 값
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int node = cur.to;
            long weight = cur.weight;
            long maxWeight = cur.maxWeight;

            if (maxWeight > maximumMoney) continue;

            if (node == destination) return true;

            if (dist[node] < weight) continue;

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                long nextCost = next[1];

                if (dist[nextNode] > weight + nextCost) {
                    dist[nextNode] = weight + nextCost;
                    q.add(new Edge(nextNode, dist[nextNode], Math.max(maxWeight, nextCost)));
                }
            }
        }

        return false;
    }
}

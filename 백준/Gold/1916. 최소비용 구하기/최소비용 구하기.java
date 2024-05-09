import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int origin = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(n, origin, dest, graph));
    }

    private static int dijkstra(int n, int origin, int dest, List<List<Edge>> graph) {
        int MAX_DIST = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[origin] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((i, j) -> Integer.compare(i.cost, j.cost));
        pq.add(new Edge(origin, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int next = edge.node;
            int nextCost = edge.cost;

            if (dist[next] < nextCost) continue;
            for (int i = 0; i < graph.get(next).size(); i++) {
                int nextNext = graph.get(next).get(i).node;
                int nextNextCost = nextCost + graph.get(next).get(i).cost;
                if (dist[nextNext] > nextNextCost) {
                    dist[nextNext] = nextNextCost;
                    pq.add(new Edge(nextNext, dist[nextNext]));
                }
            }
        }

        return dist[dest];
    }
}

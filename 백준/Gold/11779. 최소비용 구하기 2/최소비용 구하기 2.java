import java.io.*;
import java.util.*;

public class Main {

    static int INF = (int) 1e9;

    static int n, m;
    static List<Edge>[] graph;

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        // 역추적 및 다익스트라
        StringBuilder answer = new StringBuilder();
        int[] prev = new int[n + 1];

        int[] dist = new int[n + 1];
        dijkstra(startNode, endNode, dist, prev);

        answer.append(dist[endNode]).append("\n");

        Deque<Integer> stack = new LinkedList<>();
        for (int cur = endNode; cur != startNode; cur = prev[cur]) {
            stack.push(cur);
        }
        stack.push(startNode);

        answer.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            answer.append(stack.pollFirst()).append(" ");
        }

        System.out.println(answer);
    }

    static void dijkstra(int start, int destination, int[] dist, int[] prev) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        Arrays.fill(dist, INF);
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.to;
            int weight = edge.weight;

            if (dist[node] < weight) continue;

            for (Edge next : graph[node]) {
                int nextNode = next.to;
                int nextWeight = next.weight;

                if (dist[nextNode] > weight + nextWeight) {
                    dist[nextNode] = weight + nextWeight;
                    pq.add(new Edge(nextNode, dist[nextNode]));
                    prev[nextNode] = node;
                }
            }
        }
    }
}
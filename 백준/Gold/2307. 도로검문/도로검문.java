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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, t));
            graph[b].add(new Edge(a, t));
        }

        int answer = 0;
        int originalPath = 0;
        int maxPath = 0;

        int[] dist = new int[n + 1];
        Map<Integer, List<Integer>> prev = new HashMap<>();
        dijkstra(1, n, dist, prev, -1);
        originalPath = dist[n];

        List<Integer> banNodes = new ArrayList<>();
        prevDFS(banNodes, n, prev, new boolean[n + 1]);

        for (int banNode : banNodes) {
            dijkstra(1, n, dist, new HashMap<>(), banNode);
            maxPath = Math.max(maxPath, dist[n]);
        }
        
        if (originalPath == INF || maxPath == INF) answer = -1;
        else answer = maxPath - originalPath;

        System.out.println(answer);
    }

    static void dijkstra(int start, int destination, int[] dist, Map<Integer, List<Integer>> prev, int banNode) {
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

                if (nextNode == banNode) continue;

                if (dist[nextNode] > weight + nextWeight) {
                    dist[nextNode] = weight + nextWeight;
                    pq.add(new Edge(nextNode, dist[nextNode]));
                    if (banNode == -1) {
                        prev.putIfAbsent(nextNode, new ArrayList<>());
                        prev.get(nextNode).add(node);
                    }
                }
            }
        }

    }

    static void prevDFS(List<Integer> banNodes, int here, Map<Integer, List<Integer>> prev, boolean[] visited) {
        visited[here] = true;
        if (prev.get(here) == null) return;

        for (int prevNode : prev.get(here)) {
            if (visited[prevNode]) continue;
            prevDFS(banNodes, prevNode, prev, visited);
            banNodes.add(prevNode);
        }
    }

}

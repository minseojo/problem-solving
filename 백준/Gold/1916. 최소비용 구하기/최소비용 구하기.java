import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(n, graph, start, end));
    }

    static int dijkstra(int n, Map<Integer, List<int[]>> graph, int start, int end) {
        final int MAX = 987654321;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> Integer.compare(i[1], j[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        pq.add(new int[] {start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cur = top[0];
            int cost = top[1];

            if (cost > dist[cur]) continue;

            for (int[] node : graph.get(cur)) {
                int next = node[0];
                int nextCost = node[1];
                if (dist[next] > cost + nextCost) {
                    dist[next] = cost + nextCost;
                    pq.add(new int[] {next, dist[next]});
                }
            }
        }

        return dist[end];
    }
}

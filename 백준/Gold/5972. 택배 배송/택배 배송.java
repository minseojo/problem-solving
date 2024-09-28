import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int MAX = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, cost});
            graph[v].add(new int[]{u, cost});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));

        dist[1] = 0;
        pq.add(new int[]{1, 0}); // 시작 위치 1, 비용 0

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int cur = data[0];
            int cost = data[1];

            if (dist[cur] < cost) continue;

            for (int[] edge : graph[cur]) {
                int next = edge[0];
                int nextCost = edge[1];

                if (dist[next] > cost + nextCost) {
                    dist[next] = cost + nextCost;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        System.out.println(dist[n] == MAX ? -1 : dist[n]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] answer;
    static int n;
    static List<Integer>[] graph;
    static boolean[] ring;
    static boolean cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        answer = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        ring = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            cycle = false;
            findCycle(i, i, 0, new boolean[n + 1]);

            if (cycle) {
                ring[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (ring[i]) {
                sb.append(0).append(" ");
            } else {
                int nearRingLength = findNearRing(i);
                sb.append(nearRingLength).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void findCycle(int startNode, int node, int step, boolean[] visited) {
        visited[node] = true;

        for (int nextNode : graph[node]) {
            if (step >= 2 && nextNode == startNode) {
                cycle = true;
                return;
            }

            if (visited[nextNode]) continue;
            findCycle(startNode, nextNode, step + 1, visited);
        }
    }

    static int findNearRing(int node) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int neighbor : graph[cur]) {
                    if (ring[neighbor]) {
                        return count + 1;
                    }

                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
            count++;
        }

        return count;
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static boolean findLastNode = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        int[] DAG = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            DAG[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int node = 1; node <= n; node++) {
            if (DAG[node] == 0) {
                pq.add(node);
            }
        }

        System.out.println(bfs(pq, DAG, tree).toString());
    }

    private static StringBuilder bfs(PriorityQueue<Integer> pq, int[] DAG, Map<Integer, List<Integer>> tree) {
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int current = pq.poll();
            result.append(current).append(" ");
            for (int next : tree.get(current)) {
                DAG[next]--;

                if (DAG[next] == 0) {
                    pq.add(next);
                }
            }
        }

        return result;
    }
}

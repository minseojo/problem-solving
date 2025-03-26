import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            adj.get(U).add(V);
            adj.get(V).add(U);
        }

        int[][] dp = new int[N + 1][2];
        int root = 1;
        solution(root, dp, adj, A, new boolean[N + 1]);
        int answer = Math.max(dp[root][0], dp[root][1]);
        System.out.println(answer);
    }

    public static void solution(int current, int[][] dp, Map<Integer, List<Integer>> adj, int[] A, boolean[] visited) {
        visited[current] = true;

        dp[current][0] = 0;
        dp[current][1] = A[current];

        for (int i = 0; i < adj.get(current).size(); i++) {
            int next = adj.get(current).get(i);
            if (visited[next]) continue;

            solution(next, dp, adj, A, visited);

            dp[current][0] += Math.max(dp[next][0], dp[next][1]);
            dp[current][1] += dp[next][0];
        }
    }
}

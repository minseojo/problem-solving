import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

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

        StringBuilder answer = new StringBuilder();
        int[] dp = new int[N + 1];
        solution(R, dp, adj, new boolean[N + 1]);
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            answer.append(dp[U]).append("\n");
        }
        System.out.println(answer.toString());
    }

    public static int solution(int current, int[] dp, Map<Integer, List<Integer>> adj, boolean[] visited) {
        visited[current] = true;

        int result = 1;
        for (int i = 0; i < adj.get(current).size(); i++) {
            int next = adj.get(current).get(i);
            if (!visited[next]) {
                result += solution(next, dp, adj, visited);
            }
        }

        dp[current] = result;
        return result;
    }
}

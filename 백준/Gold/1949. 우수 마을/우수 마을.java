import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] town = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int root = 1;
        int[][] dp = new int[n + 1][2]; // 선택/비선택
        boolean[] visited = new boolean[n + 1];

        DFS(root, town, dp, visited, tree);
        int answer = Math.max(dp[root][0], dp[root][1]);
        System.out.println(answer);

    }

    private static void DFS(int node, int[] town, int[][] dp, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;

        dp[node][1] = town[node];
        for (int child : tree.get(node)) {
            if (!visited[child]) {
                DFS(child, town, dp, visited, tree);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }

}

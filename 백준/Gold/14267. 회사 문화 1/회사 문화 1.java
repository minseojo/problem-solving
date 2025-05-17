import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(i);
            }
        }

        int[] sum = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            sum[node] += value;
        }

        int[] dp = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        DFS(root, sum[root], sum, dp, visited, tree);
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    private static void DFS(int node, int currentSum, int[] sum, int[] dp, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;
        dp[node] = currentSum + sum[node];

        for (int child : tree.get(node)) {
            if (!visited[child]) {
                DFS(child, dp[node], sum, dp, visited, tree);
            }
        }
    }

}

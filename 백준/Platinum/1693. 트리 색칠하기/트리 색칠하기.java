import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

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
        int maxColor = 20;
        int[][] dp = new int[n + 1][maxColor + 1];
        boolean[] visited = new boolean[n + 1];

        dfs(root, maxColor, dp, visited, tree);

        int answer = Integer.MAX_VALUE;
        for (int color = 1; color <= maxColor; color++) {
            answer = Math.min(answer, dp[root][color]);
        }

        System.out.println(answer);
    }

    public static void dfs(int node, int maxColor, int[][] dp, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;

        for (int color = 1; color <= maxColor; color++) {
            dp[node][color] = color; // 이 색으로 칠했을 때의 비용
        }

        for (int child: tree.get(node)) {
            if (!visited[child]) {
                dfs(child, maxColor, dp, visited, tree);

                for (int cuurentColor = 1; cuurentColor <= maxColor; cuurentColor++) {
                    int min = Integer.MAX_VALUE;
                    for (int childColor = 1; childColor <= maxColor; childColor++) {
                        if (childColor == cuurentColor) continue;
                        min = Math.min(min, dp[child][childColor]);
                    }
                    dp[node][cuurentColor] += min;
                }
            }
        }
    }
}

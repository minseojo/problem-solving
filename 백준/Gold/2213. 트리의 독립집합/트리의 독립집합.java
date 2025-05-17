import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
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

        int[][] dp = new int[n + 1][2]; // 비선택/선택
        List<Integer> trace = new ArrayList<>(); // 비선택/선택에 따른 선택한 노드
        boolean[] visited = new boolean[n + 1];
        
        int root = 1;
        visited[root] = true;
        dfs(root, a, dp, visited, tree);
        
        visited = new boolean[n + 1];
        traceDfs(root, dp[root][1] > dp[root][0], trace, dp, visited, tree);
        Collections.sort(trace);
        
        System.out.println(Math.max(dp[root][0], dp[root][1]));
        for (Integer i : trace) {
            System.out.print(i + " ");
        }
    }

    public static void dfs(int node, int[] a, int[][] dp, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;

        dp[node][0] = 0;
        dp[node][1] = a[node];
        for (int child: tree.get(node)) {
            if (!visited[child]) {
                dfs(child, a, dp, visited, tree);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]); // 선택하지 않은 경우, 자식 고려 X
                dp[node][1] += dp[child][0]; // 선택한 경우, 자식은 선택 X
            }
        }
    }
    
    public static void traceDfs(int node, boolean isSelected, List<Integer> trace, int[][] dp, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;
        if (isSelected) {
            trace.add(node);
        }
        
        for (int child: tree.get(node)) {
            if (!visited[child]) {
                if (isSelected) {
                    traceDfs(child, false, trace, dp, visited, tree); // 부모가 선택 됐으먼, 자식은 선택 X
                } else {
                    // 부모가 선택 안된 경우
                    if (dp[child][1] > dp[child][0]) { // 자식을 선택 한 경우가 더 큰 경우에만 선택
                        traceDfs(child, true, trace, dp, visited, tree); 
                    } else {
                        traceDfs(child, false, trace, dp, visited, tree);
                    }
                }
            }
        }
       
    }
}

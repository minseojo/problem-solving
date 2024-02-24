import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] result = new int[100_001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(r, tree, visited);
        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            System.out.println(result[u]);
        }
    }

    private static int dfs(int parent, List<List<Integer>> tree, boolean[] visited) {
        int ans = 1;
        visited[parent] = true;

        for (int i = 0; i < tree.get(parent).size(); i++) {
            int child = tree.get(parent).get(i);
            if (!visited[child]) {
                ans += dfs(child, tree, visited);
            }
        }
        
        result[parent] = ans;
        return ans;
    }
}

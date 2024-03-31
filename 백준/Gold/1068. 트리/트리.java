import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) root = i;
            else {
                tree.get(x).add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());
        if (root == deleteNode) {
            System.out.println(0);
        } else {
            boolean[] visited = new boolean[n];
            visited[deleteNode] = true;
            System.out.println(dfs(root, tree, visited));
        }
    }

    private static int dfs(int here, List<List<Integer>> tree, boolean[] visited) {
        visited[here] = true;

        if (tree.get(here).size() == 0) return 1;
        else if (tree.get(here).size() == 1 && visited[tree.get(here).get(0)]) return 1;
        int result = 0;
        for (int i = 0; i < tree.get(here).size(); i++) {
            int next = tree.get(here).get(i);

            if (!visited[next]) {
                result += dfs(next, tree, visited);
            }
        }

        return result;
    }
}
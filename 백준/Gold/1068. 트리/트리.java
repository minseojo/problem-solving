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
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
               root = i;
            } else {
                tree.get(x).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        int deleteNode = Integer.parseInt(br.readLine());
        int answer = DFS(root, deleteNode, visited, tree);
        System.out.println(answer);
    }


    private static int DFS(int node, int deleteNode, boolean[] visited, Map<Integer, List<Integer>> tree) {
        visited[node] = true;
        if (node == deleteNode) return 0; // 루트가 삭제 된 경우

        int result = 0;
        int childCount = 0;
        for (int child : tree.get(node)) {
            if (child == deleteNode) continue;

            if (!visited[child]) {
                childCount++;
                result += DFS(child, deleteNode, visited, tree);
            }
        }

        if (childCount == 0) return result + 1;
        return result;
    }

}

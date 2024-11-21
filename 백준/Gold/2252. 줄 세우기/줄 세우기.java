import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        int[] dag = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            dag[b]++;
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dag[i] == 0 && !visited[i]) {
                dfs(i, graph, visited, dag);
            }
        }

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int here, Map<Integer, List<Integer>> graph, boolean[] visited, int[] dag) {
        visited[here] = true;
        answer.add(here);

        for (int i = 0; i < graph.get(here).size(); i++) {
            int next = graph.get(here).get(i);
            dag[next]--;
            if (dag[next] == 0 &&!visited[next] ) {
                dfs(next, graph, visited, dag);
            }
        }
    }

}
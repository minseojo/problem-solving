import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int NOT_VISITED = -1;
    static int NOT_EARLY_ADOPTER = 0;
    static int EARLY_ADOPTER = 1;


    static int n;
    static Map<Integer, List<Integer>> tree;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }
        visited = new boolean[n  + 1];
        result = new int[n + 1];
        Arrays.fill(result, NOT_VISITED);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] > 0) answer++;
        }
        System.out.println(answer);
    }

    static int dfs(int here) {
        visited[here] = true;

        for (int next : tree.get(here)) {
            if (!visited[next]) {
                int nextValue = dfs(next);

                if (result[here] != EARLY_ADOPTER && nextValue == EARLY_ADOPTER) {
                    result[here] = NOT_EARLY_ADOPTER;
                } else {
                    result[here] = EARLY_ADOPTER;
                }
            }
        }

        if (result[here] == NOT_VISITED) {
            result[here] = NOT_EARLY_ADOPTER;
        }

        return result[here];
    }
}

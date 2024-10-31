import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < tcc; tc++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] link = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                link[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                   if (dfs(i, i, link, visited) == 1) answer++;
                }
            }

            System.out.println(answer);
        }
    }

    static int dfs(int start, int here, int[] link, boolean[] visited) {
        visited[here] = true;

        int result = 0;
        int next = link[here];
        if (next == start) return 1;

        if (!visited[next]) result += dfs(start, next, link, visited);

        return result;
    }
}
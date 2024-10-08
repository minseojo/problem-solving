import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] a;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        dp = new int[1 << n][n + 1];  // 배열 크기 주의

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int answer = INF;
        answer = Math.min(answer, TSP(1, 1, 1));
        System.out.println(answer);
    }

    static int TSP(int path, int currentCity, int start) {
        if (path == (1 << n) - 1) {
            return a[currentCity][start] == 0 ? INF : a[currentCity][start];
        }
        if (dp[path][currentCity] != -1) return dp[path][currentCity];
        dp[path][currentCity] = INF;
        for (int next = 1; next <= n; next++) {
            if ((path & (1 << (next - 1))) != 0 || a[currentCity][next] == 0) continue;
            int cost = a[currentCity][next] + TSP(path | (1 << (next - 1)), next, start);
            dp[path][currentCity] = Math.min(dp[path][currentCity], cost);
        }

        return dp[path][currentCity];
    }
}

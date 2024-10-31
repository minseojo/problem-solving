import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n + 1][n + 1];
        int[][][] dp = new int[3][n + 1][n + 1]; // [3] = 가로, 세로, 대각선
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][1] = 1;
        dp[0][1][2] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (a[i][j] == 1) continue;

                if (a[i - 1][j] == 0) dp[1][i][j] += (dp[1][i - 1][j] + dp[2][i - 1][j]);
                if (a[i][j - 1] == 0) dp[0][i][j] += (dp[0][i][j - 1] + dp[2][i][j - 1]);
                if (a[i - 1][j] == 0 && a[i][j - 1] == 0 && a[i - 1][j - 1] == 0) dp[2][i][j] += (dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1]);
            }
        }

        System.out.println(dp[0][n][n] + dp[1][n][n] + dp[2][n][n]);
    }
}
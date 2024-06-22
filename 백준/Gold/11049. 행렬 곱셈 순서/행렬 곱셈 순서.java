import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] matrix;
    private static int[][] dp;

    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[i][0] = a;
            matrix[i][1] = b;
        }

        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int l = j;
                int r = j + i;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + matrix[l][0] * matrix[k][1] * matrix[r][1]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
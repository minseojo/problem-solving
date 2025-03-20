import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, m, a));
    }

    public static int solution(int n, int m, int[][] a) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i] = dp[1][i - 1] + a[1][i];
        }

        for (int i = 2; i <= n; i++) {
            int[][] temp = new int[2][m + 1];

            // 맨왼쪽,위 > 아래 > 오른쪽 쭉
            temp[0][1] = dp[i - 1][1] + a[i][1];
            for (int j = 2; j <= m; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + a[i][j];
            }

            // 맨오른쪽,위 > 아래 > 왼쪽 쭉
            temp[1][m] = dp[i - 1][m] + a[i][m];
            for (int j = m - 1; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + a[i][j];
            }

            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        return dp[n][m];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n + 1][2]; // [index, (row=0 | column=1)]
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, a));
    }

    public static int solution(int n, int[][] a) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int l = 1; l <= n - i; l++) {
                int r = l + i;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + a[l][0] * a[k][1] * a[r][1]);
                }
            }
        }

        return dp[1][n];
    }
}

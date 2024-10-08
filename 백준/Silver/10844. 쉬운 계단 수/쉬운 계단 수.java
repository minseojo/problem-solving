import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_000;

    static int n;
    static int[][] dp = new int[101][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                } else {
                    dp[i][j] = ((dp[i - 1][j - 1] % MOD) + (dp[i - 1][j + 1] % MOD)) % MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % MOD);
    }
}

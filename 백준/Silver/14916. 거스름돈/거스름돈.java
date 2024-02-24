import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[100_001];
        int INF = 1_000_000;
        for (int i = 0; i <= n; i++) {
            dp[i] = INF;
        }

        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            if (dp[i - 5] != INF) {
                dp[i] = dp[i - 5] + 1;
            }
            if (dp[i - 2] != INF){
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            } else {
                dp[i] = INF;
            }
        }

        if (dp[n] != INF) {
            System.out.println(dp[n]);
        } else {
            System.out.println(-1);
        }
    }
}

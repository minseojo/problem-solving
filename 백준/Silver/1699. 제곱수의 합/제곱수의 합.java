import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int MAX = 100_001;
        int[] dp = new int[MAX + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i * i <= MAX; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i] , dp[i - 1] + 1);
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + dp[j * j]);
            }
        }

        System.out.println(dp[n]);
    }
}

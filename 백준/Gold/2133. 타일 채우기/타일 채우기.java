import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[31];
        dp[2] = 3;
        if (n % 2 == 0) {
            for (int i = 4; i <= n; i+= 2) {
                dp[i] = 3 * dp[i - 2] + 2;
                for (int j = 4; j < i; j+= 2) {
                    dp[i] += 2 * dp[i - j];
                }
            }
        }

        System.out.println(dp[n]);
    }
}

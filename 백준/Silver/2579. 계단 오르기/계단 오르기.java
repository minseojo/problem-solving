import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_000;

    static int n;
    static int[] dp = new int[301];
    static int[] a = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = a[0];
        dp[1] = a[0] + a[1];
        dp[2] = Math.max(a[0] + a[2], a[1] + a[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]);
        }
        System.out.println(dp[n - 1]);
    }
}

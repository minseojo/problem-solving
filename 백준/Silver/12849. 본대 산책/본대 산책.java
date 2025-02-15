import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        int[] dp = new int[8];
        dp[0] = 1;

        for (int i = 0; i < D; i++) {
            int[] temp = new int[8];
            for (int j = 0; j < 8; j++) {
                dp[j] %= MOD;
            }
            temp[0] = dp[1] + dp[2];
            temp[1] = ((dp[0] + dp[2]) % MOD + dp[3]) % MOD;
            temp[2] = (dp[0] + dp[1]) % MOD + (dp[3] + dp[4]) % MOD;
            temp[3] = (dp[1] + dp[2]) % MOD + (dp[4] + dp[5]) % MOD;
            temp[4] = ((dp[2] + dp[3]) % MOD + (dp[5] + dp[6]) % MOD) % MOD;
            temp[5] = ((dp[3] + dp[4]) % MOD + dp[7]) % MOD;
            temp[6] = dp[4] + dp[7];
            temp[7] = dp[5] + dp[6];
            for (int j = 0; j < temp.length; j++) {
                dp[j] = temp[j] % MOD;
            }
        }
        System.out.println(dp[0] % MOD);
        br.close();
    }

}

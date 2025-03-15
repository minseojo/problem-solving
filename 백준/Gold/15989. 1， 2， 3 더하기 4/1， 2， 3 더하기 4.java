import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX_SIZE = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = createTable();
        
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }

    public static int[][] createTable() {
        int[][] dp = new int[MAX_SIZE + 1][4];

        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;

        for (int i = 3; i <= MAX_SIZE; i++) {
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][2] = dp[i - 2][2] + dp[i - 2][3];
            dp[i][3] = i % 3 == 0 ? 1 : 0;
        }

        return dp;
    }
}

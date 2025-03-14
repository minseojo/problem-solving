import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] a = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(t, w, a));
    }

    public static int solution(int t, int w, int[] a) {
        int[][][] dp = new int[t + 1][w + 1][3];
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + (a[i] == 1 ? 1 : 0);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + (a[i] == 1 ? 1 : 0);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + (a[i] == 2 ? 1 : 0);
                }
            }
        }

        return Math.max(dp[t][w][1], dp[t][w][2]);
    }
}

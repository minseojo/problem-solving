import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] result = new int[100_001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int MAX = 1000;
        int[][] rgb = new int[MAX + 1][MAX + 1];
        int[][] dp = new int[MAX + 1][MAX + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rgb[i][1] = a;
            rgb[i][2] = b;
            rgb[i][3] = c;
        }

        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];
        dp[1][3] = rgb[1][3];
        for (int i = 2 ; i <= n; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + rgb[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][3];
        }

        int answer = 1000 * 1000;
        for (int i = 1; i <= 3; i++) {
            answer = Math.min(answer, dp[n][i]);
        }
        System.out.println(answer);

    }
}

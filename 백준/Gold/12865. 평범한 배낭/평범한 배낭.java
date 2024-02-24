import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];

        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            input[i][0] = w;
            input[i][1] = v;
        }

        for (int i = 0; i < n; i++) {
            int w = input[i][0];
            int v = input[i][1];

            for (int j = k; j >= 0; j--) {
                if (j - w >= 0) {
                    dp[j] = Math.max(dp[j], v + dp[j-w]);
                }
            }
        }

        System.out.println(dp[k]);
    }
}

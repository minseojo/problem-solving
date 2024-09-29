import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int MAX = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
        
            int[] dp = new int[10001];
            dp[0] = 1;
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                int x = arr[i];
                for (int j = x; j <= m; j++) {
                    dp[j] += dp[j - x];
                }
            }
            System.out.println(dp[m]);
        }
    }
}

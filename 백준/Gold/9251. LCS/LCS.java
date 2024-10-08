import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        int[][] dp = new int[b.length() + 2][a.length() + 2];
        for (int i = 1; i <= b.length(); i++) {
            char cb = b.charAt(i - 1);
            for (int j = 1; j <= a.length(); j++) {
                char ca = a.charAt(j - 1);
                if (cb == ca) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }

}

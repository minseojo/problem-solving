import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(solution(n, a));
        sc.close();
    }

    public static int solution(int n, int[] a) {
        int[] dp = new int[n + 1];
        if (n >= 1) dp[1] = a[1];
        if (n >= 2) dp[2] = dp[1] + a[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(a[i - 1] + dp[i - 3], dp[i - 2]) + a[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[n];
    }
}

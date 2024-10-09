import java.util.*;

class Solution {

    int MAX = 987654321;

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[10001];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        Arrays.sort(coins);
        for (int c : coins) {
            if (c > 10000) continue;
            dp[c] = 1;
        }

        for (int c : coins) {
            if (c > 10000 || c < 0) continue;
            for (int i = c + 1; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[c] + dp[i - c]);
            }
        }

        return dp[amount] >= MAX ? -1 : dp[amount];
    }
}
class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        int MOD = 1_000_000_007;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD;
        }
            
        return dp[n] % MOD;
    }
}
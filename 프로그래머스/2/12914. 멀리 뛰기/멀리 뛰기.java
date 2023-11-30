class Solution {
    public long solution(int n) {
        int MOD = 1234567;
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] % MOD+ dp[i - 1] % MOD;
        }
        
        return dp[n] % MOD;
    }
}
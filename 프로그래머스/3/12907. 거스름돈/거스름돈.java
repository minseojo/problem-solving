class Solution {
    
    private final static int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        
        for (int m : money) {
            dp[m]++; 
            for (int j = m; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - m]) % MOD;
            }
        }
        
        return dp[n];
    }
}
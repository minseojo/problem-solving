class Solution {

    static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int[] sum = new int[n + 1];
        
        for (int m : money) {
            sum[m]++;
            for (int j = 1; j <= n; j++) {
                if (j - m > 0) {
                    sum[j] = (sum[j] + sum[j - m]) % MOD;
                }
            }
        }
        
        return sum[n];
    }
}
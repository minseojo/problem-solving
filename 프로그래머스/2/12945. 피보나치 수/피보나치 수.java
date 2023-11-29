class Solution {
    public int solution(int n) {
        int MOD = 1234567;

        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] % MOD + fibo[i - 2] % MOD;
        }
        
        return fibo[n] % MOD;
    }
}
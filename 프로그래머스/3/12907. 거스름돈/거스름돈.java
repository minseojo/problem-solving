import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int[] sum = new int[n + 1];
        sum[0] = 1; 
        
        Arrays.sort(money);
        
        for (int m : money) {
            for (int j = m; j <= n; j++) {
                sum[j] = (sum[j] + sum[j - m]) % MOD;
            }
        }
        
        return sum[n];
    }
}
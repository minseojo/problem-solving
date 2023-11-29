import java.util.*;

class Solution {
    public static final int MAX_VALUE = 10_000;
    
    public int solution(int n) {
        int answer = 0;
        int[] sum = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            sum[i] += i + sum[i - 1];
        }
        
        int l = 0;
        int r = 1;
        while (r <= n) {
            int tmp = sum[r] - sum[l];
            if (tmp == n) {
                answer++;
                l++;
                r++;
            }       
            else if (tmp < n) {
                r++;
            } 
            else if (tmp > n) {
                l++;
                r = l + 1;
            }
        }
        
        return answer;
    }
}
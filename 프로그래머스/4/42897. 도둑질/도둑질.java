import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = f1(money);
        answer = Math.max(answer, f2(money));
        return answer;
    }
    
    private int f1(int[] money) {
        int result = 0;
        int size = money.length;
        int[] dp = new int[size];
        dp[0] = money[0];
        dp[1] = Math.max(money[1], dp[0]);
        for (int i = 2; i < size - 1; i++) {
            dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
        }
        
        for (int i : dp) {
            result = Math.max(result, i);
        }
        return result;
    }
    
    private int f2(int[] money) {
        int result = 0;
        int size = money.length;
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = Math.max(money[1], dp[0]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
        }
        
        for (int i : dp) {
            result = Math.max(result, i);
        }
        return result;
    }
}
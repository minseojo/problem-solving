class Solution {
    public int solution(int[] money) {        
        int[][] dp = new int[2][money.length];

        dp[0][0] = money[0]; // 처음을 고른 경우
        dp[0][1] = money[0];
        
        dp[1][0] = 0;        // 마지막을 고른 경우
        dp[1][1] = money[1];

        for(int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 2] + money[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);
        }

        return Math.max(dp[0][dp[0].length  -2], dp[1][dp[1].length - 1]);
    }
}

/*
처음에 푼 풀이
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
*/
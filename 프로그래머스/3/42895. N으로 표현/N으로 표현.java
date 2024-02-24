import java.util.*;

class Solution {
    int answer;
    public int solution(int N, int number) {
        answer = Integer.MAX_VALUE;
        int[] x = new int[11];
        for (int i = 1; i <= 9; i++) {
            String tmp = "";
            for (int j = 0; j < i; j++) {
                tmp += N;
            }
            x[i] = Integer.valueOf(tmp);
        }
        dp(N, number, 0, 0, x);

        if (answer > 8) return -1;
        return answer;
    }
    
    private void dp(int N, int number, int cur, int count, int[] x) {
        if (count > 8 ) {
            return;
        }
        
        if (cur == number) {
            answer = Math.min(answer, count);
        }
        
        for (int i = 1; i <= 9; i++) {
            dp(N, number, cur + x[i], count + i, x);  
            dp(N, number, cur - x[i], count + i, x); 
            dp(N, number, cur * x[i], count + i, x); 
            dp(N, number, cur / x[i], count + i, x);
        }
    }
}
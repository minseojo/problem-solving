class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        int answer = 0;
        int[][] dp = new int[2][sticker.length]; // 맨 앞을 선택한 경우, 맨 앞을 선택하지 않은 경우
        
        dp[0][0] = sticker[0];
        dp[1][0] = 0;
        dp[0][1] = dp[0][0];
        dp[1][1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            dp[0][i] =  Math.max(dp[0][i-2] + sticker[i], dp[0][i-1]);
            dp[1][i] =  Math.max(dp[1][i-2] + sticker[i], dp[1][i-1]);
        }
        
        for (int i = 0; i < sticker.length - 1; i++) {
            answer = Math.max(answer, dp[0][i]);
        }
        for (int i = 1; i < sticker.length; i++) {
            answer = Math.max(answer, dp[1][i]);
        }

        return answer;
    }
}

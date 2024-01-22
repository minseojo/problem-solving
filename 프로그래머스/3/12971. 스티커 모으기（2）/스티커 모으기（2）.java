class Solution {
    public int solution(int sticker[]) {        
        if (sticker.length == 1) {
            return sticker[0];
        }
        
        int[] sticker2 = new int[sticker.length + 1];
        for (int i = 0; i < sticker.length; i++) {
            sticker2[i] = sticker[i];
        }
        sticker2[sticker.length] = sticker[0];
        
        int[][] dp = new int[3][sticker2.length];
        dp[0][0] = sticker2[0]; // 첫번째 넣은 경우
        dp[0][1] = sticker2[0];
        dp[1][0] = 0; // 두번째에 넣은 경우
        dp[1][1] = sticker2[1];
        dp[1][2] = sticker2[1];
        dp[2][0] = 0; // 첫번째 두번째 모두 안넣은 경우
        dp[2][1] = 0;
        
        for (int i = 2; i < sticker.length - 1; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + sticker2[i]);
        }
        for (int i = 3; i < sticker2.length - 1; i++) {
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + sticker2[i]);
        }
        for (int i = 2; i < sticker2.length-1; i++) {
            dp[2][i] = Math.max(dp[2][i-1], dp[2][i-2] + sticker2[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < sticker2.length; i++) {
            answer = Math.max(answer, dp[0][i]);
            answer = Math.max(answer, dp[1][i]);
            answer = Math.max(answer, dp[2][i]);
        }
        return answer;
    }
}
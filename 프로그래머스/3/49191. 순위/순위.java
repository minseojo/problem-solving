class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n + 1][n + 1];
        for (int[] r : results) {
            win[r[0]][r[1]] = true;
        }
        
        for (int k = 1; k <= n; k++) { // x
            for (int i = 1; i <= n; i++) { // x한테 진 사람
                for (int j = 1; j <= n; j++) { // x 이긴 사람
                    if (win[j][k] && win[k][i]) {
                        win[j][i] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (win[i][j] || win[j][i]) count++;
            }
            if (count == n - 1) answer++;
        }
        
        return answer;
    }
}
class Solution {
    

    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n + 1][n + 1];
        for (int[] r : results) {
            int winner = r[0];
            int looser = r[1];
            win[winner][looser] = true;
        }       
        
        for (int k = 1; k <= n; k++) { // x
            for (int i = 1; i <= n; i++) { // x를 이긴 사람 
                for (int j = 1; j <= n; j++) { // x에게 진 사람
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (win[i][j] || win[j][i]) count++;
            }
            if (count + 1 == n) answer++;
        }
        return answer;
    }
}
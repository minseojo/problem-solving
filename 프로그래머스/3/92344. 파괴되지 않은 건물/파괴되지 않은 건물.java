class Solution {
    static int ATTACK = 1;
    static int HEAL = 2;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int[] s : skill) {
            int sy = s[1], sx = s[2];
            int ey = s[3], ex = s[4];
            int degree = s[5];
            
            if (s[0] == ATTACK) {
                degree *= -1;
            }
           
            sum[sy][sx] += degree;
            sum[sy][ex + 1] -= degree;
            sum[ey + 1][sx] -= degree;
            sum[ey + 1][ex + 1] += degree;

        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int x = 0;
                if (i-1 >= 0) x += sum[i-1][j];
                if (j-1 >= 0) x += sum[i][j-1];
                if (i-1 >= 0 && j-1 >= 0) x -= sum[i-1][j-1];
                sum[i][j] += x;
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
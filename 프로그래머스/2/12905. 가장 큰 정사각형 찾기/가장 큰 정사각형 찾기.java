class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    int minValue = 1001;
                    minValue = Math.min(minValue, board[i-1][j]);
                    minValue = Math.min(minValue, board[i][j-1]);
                    minValue = Math.min(minValue, board[i-1][j-1]);
                    board[i][j] = minValue + 1;
                }
            }
        }
        
        /*
        입력
        [[1, 0], [0, 0]] 
        
        출력
        1
        */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                answer = Math.max(answer, board[i][j] * board[i][j]);
            }
        }
        
        return answer;
    }
}
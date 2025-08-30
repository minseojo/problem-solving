class Solution {

    static int n = 9;

    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && checkBox(board);
    }

    boolean checkRow(char[][] board) {
        for (int i = 0; i < n; i++) {
            int[] num = new int[10];
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                num[board[i][j] - '0']++;
                if (num[board[i][j] - '0'] > 1) return false;
            }
        }
        return true;
    }

    boolean checkCol(char[][] board) {
        for (int i = 0; i < n; i++) {
            int[] num = new int[10];
            for (int j = 0; j < n; j++) {
                if (board[j][i] == '.') continue;
                num[board[j][i] - '0']++;
                if (num[board[j][i] - '0'] > 1) return false;
            }
        }
        return true;
    }

    boolean checkBox(char[][] board) {
        for (int i = 0; i < n; i+=3) {     // 시작 y 좌표
            for (int j = 0; j < n; j+=3) { // 시작 x 좌표

                int[] num = new int[10];
                for (int y = i; y < i+3; y++) {
                    for (int x = j; x < j+3; x++) {
                        if (board[y][x] == '.') continue;
                        num[board[y][x] - '0']++;
                        if (num[board[y][x] - '0'] > 1) return false;
                    }
                }
            }
        }
        return true;
    }
}
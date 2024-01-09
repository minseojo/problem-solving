import java.util.*;

class Solution {
    class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return y == p.y && x == p.x;
            }
            
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
    
    public int solution(int m, int n, String[] board2) {
        int answer = 0;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board2[i].charAt(j);
            }
        }
        
        while (true) {
            Set<Point> result = new HashSet<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (board[i][j] != ' ' && check(i, j, board)) {
                        result.add(new Point(i, j));
                        result.add(new Point(i + 1, j));
                        result.add(new Point(i, j + 1));
                        result.add(new Point(i + 1, j + 1));
                    }
                }
            }
            
            if (result.isEmpty()) {
                break;
            }
            answer += result.size();
            
            for (Point p : result) {
                board[p.y][p.x] = ' ';
            }
            
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != ' ' && board[i + 1][j] == ' ') {
                        char c = board[i][j];
                        int ny = i + 1;
                        while (ny < m - 1 && board[ny + 1][j] == ' ') {
                            ny++;
                        }
                        board[i][j] = ' ';
                        board[ny][j] = c;
                    }
                }
            }
        }
        
    
            
        return answer;
    }
    
    private boolean check(int y, int x, char[][] board) {
        char c = board[y][x];
        for (int i = y; i <= y + 1; i++) {
            for (int j = x; j <= x + 1; j++) {
                if (c != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
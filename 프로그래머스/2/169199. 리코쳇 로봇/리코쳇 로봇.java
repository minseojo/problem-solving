import java.util.*;

class Solution {
    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    class Robot {
        int y;
        int x;
        Robot(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int[][] cache = new int[100][100];
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Robot> q = new LinkedList<>();
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    visited[i][j] = true;
                    q.add(new Robot(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Robot curQ = q.poll();
                int y = curQ.y;
                int x = curQ.x;

                if(board[y].charAt(x) == 'G') {
                    return answer;
                }

                for(int i=0; i<4; i++) {
                    int ny = y + dir[i][0];
                    int nx = x + dir[i][1];
                    if(ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1) continue;

                    while(true) {
                        if(ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1 || board[ny].charAt(nx) == 'D') {
                            break;
                        }                    
                        ny += dir[i][0];
                        nx += dir[i][1];
                    }

                    ny -= dir[i][0];
                    nx -= dir[i][1];
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new Robot(ny, nx));
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
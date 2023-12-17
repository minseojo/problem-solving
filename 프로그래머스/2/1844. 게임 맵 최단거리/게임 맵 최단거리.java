/*
시작: 0, 0
끝: n-1, m-1
*/
import java.util.*;

class Solution {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    
    class Position {
        public int y;
        public int x;
        
        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Position(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            while (size-- > 0) {
                Position p = q.poll();
                int y = p.y;
                int x = p.x;
                if (y == n - 1 && x == m - 1) {
                    return answer;
                }
                
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1) {
                        continue;
                    }
                    if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new Position(ny, nx));
                    }
                }
            }
        }
        
        return -1;
    }
}
import java.util.*;

class Solution {
    
    class Position {
        int y;
        int x;
        
        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] road = new int[102][102];
       
        for (int[] r : rectangle) {
            int sy = r[0] * 2;
            int sx = r[1] * 2;
            int ey = r[2] * 2;
            int ex = r[3] * 2;
            for (int i = sy; i <= ey; i++) {
                for (int j = sx; j <= ex; j++) {
                    road[i][j] = 1;
                }
            }
        }
        
        boolean[][] check = new boolean[102][102];
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (road[i][j] == 1 && road[i][j-1] == 0 || road[i][j+1] == 0 ||
                   road[i-1][j-1] == 0 || road[i-1][j] == 0 || road[i-1][j+1] == 0 ||
                   road[i+1][j-1] == 0 || road[i+1][j] == 0 || road[i+1][j+1] == 0) {
                    check[i][j] = true;
                }
            }
        }
        
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (!check[i][j]) {
                    road[i][j] = 0;
                }
            }
        }
        
        answer = bfs(road, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }
    
    private int bfs(int[][] road, int sy, int sx, int ey, int ex) {
        if (sy == ey && sx == ex) return 0;
        
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.add(new Position(sy, sx));
        visited[sy][sx] = true;
        
        int result = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Position p = q.poll();
                int y = p.y;
                int x = p.x;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if (ny == ey && nx == ex) {
                        return result / 2;
                    }
                    if (ny < 1 || nx < 1 || ny > 100 || nx > 100) continue;
                    if (road[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new Position(ny, nx));
                    }
                }
            }
            result++;
        }
        
        return -1;
    }
}
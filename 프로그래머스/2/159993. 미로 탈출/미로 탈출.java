import java.util.*;

class Solution {
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    class Point {
        int y;
        int x;
        int hasLever;
        
        Point(int y, int x, int hasLever) {
            this.y = y;
            this.x = x;
            this.hasLever = hasLever;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int[][][] map = new int[2][maps.length][maps[0].length()];
                
        Queue<Point> q = new LinkedList<>();
        
        int ey = 0, ex = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    q.add(new Point(i, j, 0));
                    map[0][i][j] = 1;
                }
                if (c == 'E') {
                    ey = i;
                    ex = j;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                int y = p.y;
                int x = p.x;
                int hasLever = p.hasLever;
                map[hasLever][y][x] = 1;
                if (y == ey && x == ex && hasLever == 1) return answer;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length()) continue;
                    if (map[hasLever][ny][nx] == 1 || maps[ny].charAt(nx) == 'X') continue;
                    
                    if (maps[ny].charAt(nx) == 'L') {
                        map[1][ny][nx] = 1;
                        q.add(new Point(ny, nx, 1));
                    }
                    else {
                        q.add(new Point(ny, nx, hasLever));
                        map[hasLever][ny][nx] = 1;
                    }
                }
            }
            answer++;
        }
        
        return -1;
    }
}
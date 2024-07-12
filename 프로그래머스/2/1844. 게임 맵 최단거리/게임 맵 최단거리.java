import java.util.*;

class Solution {
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};

    static class Position {
        int y;
        int x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Deque<Position> q = new ArrayDeque<>();
        q.add(new Position(0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            while (size-- > 0) {
                Position cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                if (y == n - 1 && x == m - 1) {
                    return answer;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
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
import java.util.*;


class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    class Position {
        public int y;
        public int x;
        public int count;
        Position(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        int[][] cache = new int[land.length][land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (!visited[j][i] && land[j][i] == 1) {
                    bfs(j, i, land, cache, visited);
                }
            }
        }
        
                
        for (int i = 0; i < land[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < land.length; j++) {
                sum += cache[j][i];
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    private void bfs(int sy, int sx, int[][] land, int[][]cache, boolean[][] visited) {
        Queue<Position> q = new LinkedList<>();
        Queue<Position> mq = new LinkedList<>();
        q.add(new Position(sy, sx, 1));
        int result = 0;
        visited[sy][sx] = true;
        while(!q.isEmpty()) {
            Position p = q.poll();
            int y = p.y;
            int x = p.x;
            int count = p.count;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny > land.length - 1 || nx > land[0].length - 1) {
                    continue;
                }
                if (!visited[ny][nx] && land[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    mq.add(new Position(ny, nx, -1));
                    q.add(new Position(ny, nx, count + 1));
                }
            }
            result++;
        }

        mq.add(new Position(sy, sx, -1));
        boolean[] mvisited = new boolean[land[0].length];
        while (!mq.isEmpty()) {
            Position p = mq.poll();
            if (!mvisited[p.x]) {
                mvisited[p.x] = true;
                cache[p.y][p.x] = result;   
            }
        }
    }
}
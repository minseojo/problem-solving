class Solution {
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, -1, 0, 1};
    public int[][] solution(int n) {
        int[][] map = new int[n][n];
        int y = 0, x = 0, cnt = 1;
        int dir = 0;

        for(int i=0; i<n; i++) {
            map[0][i] = cnt++;
            x++;
        }
        x--;
        
        while (n > 0) {
            int size = n-1;
            while(size > 0) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                map[ny][nx] = cnt++;
                y += dy[dir];
                x += dx[dir];
                size--;
            }

            dir = (dir+1) % 4;
            if(dir == 0 || dir == 2) n--;
        }
        
        return map;
    }
}
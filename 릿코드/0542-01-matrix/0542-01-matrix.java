class Solution {
    int[][] dist;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<int[]>();
        int n = mat.length, m = mat[0].length;
        dist = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
                else dist[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()) {
            int y = q.peek()[0];
            int x = q.peek()[1];
            q.remove();
            
            for(int i=0; i<4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if(ny < 0 || nx < 0 || ny == n || nx == m || dist[ny][nx] != -1) continue;              

                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }        
        
        return dist;
    }
}
class Solution {    
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(boolean i[] : visited) Arrays.fill(i, false);
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    result = Math.max(result, bfs(i, j, visited, grid));
                    System.out.println(result);
                }
            }
        }
        
        return result;
    }
    
    int bfs(int sy, int sx, boolean[][] visited, int[][] grid) {
        visited[sy][sx] = true;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{sy, sx});
        int count = 1;
        while(!q.isEmpty()) {
            int[] d = q.poll();
            int y = d[0];
            int x = d[1];
            
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny > grid.length-1 || nx > grid[ny].length-1) continue;
                if(!visited[ny][nx] && grid[ny][nx] == 1) {
                    count++;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        return count;
    }
}
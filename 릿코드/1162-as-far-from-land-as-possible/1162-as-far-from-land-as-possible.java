class Solution {
    public int maxDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }

        int answer = 0;
        answer = bfs(q, grid, visited);
        if(answer == 0) return -1;
        else return answer;
    }

    public int bfs(Queue<int[]> q, int[][] grid, boolean[][] visited) {
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int result = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            result++;
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];

                for(int j=0; j<4; j++) {
                    int ny = y + dir[j][0];
                    int nx = x + dir[j][1];
                    if(ny<0 || nx<0 || ny>grid.length-1 || nx > grid[0].length-1) continue;
                    if(!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        return result-1;
    }
}
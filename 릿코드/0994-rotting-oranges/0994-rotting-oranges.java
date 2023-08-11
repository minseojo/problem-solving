class Solution {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1) {
            if(grid[0][0] == 1) return -1;
            else return 0;
        }
        
        int answer = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<int[]>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(q.size() > 0) {
            answer = bfs(grid, q, visited);
        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    answer = -1;
                }
            }
        }

        return answer;
    }
    
    int bfs(int[][] grid, Queue<int[]> q, boolean[][] visited) {
        int result=-1;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int y = q.peek()[0];
                int x = q.peek()[1];
                q.remove();
                for(int j=0; j<4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny < 0 || nx < 0 || ny > grid.length-1 || nx > grid[0].length-1) continue;

                    if(grid[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        grid[ny][nx] = 2;
                        System.out.println(ny + " " + nx);
                        q.add(new int[]{ny, nx});
                    }
                }
            }
            result++;
        }

        return result;
    }
    
}
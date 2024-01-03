class Solution {
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    int result = 0;
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        int[] answer = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] > 0) {
                    answer[0]++;
                    result = 0;
                    dfs(i, j, picture, visited);
                    answer[1] = Math.max(answer[1], result);
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int y, int x, int[][] picture, boolean[][] visited) {
        visited[y][x] = true;
        result++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny > picture.length - 1 
                || nx > picture[0].length - 1 || visited[ny][nx]) {
                continue;
            }
            
            if (picture[y][x] == picture[ny][nx]) {
                dfs(ny, nx, picture, visited);
            }
        }
    }
}
class Solution {

    public int numIslands(char[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }

        return answer;
    }

    void dfs(int y, int x, char grid[][]) {
        if (y < 0 || x < 0 || y > grid.length - 1 || x > grid[0].length - 1 || grid[y][x] == '0') return;

        grid[y][x] = '0';

        dfs(y - 1, x, grid);
        dfs(y + 1, x, grid);
        dfs(y, x - 1, grid);
        dfs(y, x + 1, grid);
    }
}
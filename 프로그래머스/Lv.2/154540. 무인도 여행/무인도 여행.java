import java.util.*;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    int count;
    
    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, maps, visited);
                    result.add(count);
                }
            }
        }
        
        if (result.isEmpty()) {
            return new int[] {-1};
        }
        
        return result.stream()
                .mapToInt(i -> i)
                .sorted()
                .toArray();
    }
    
    private void dfs(int y, int x, String[] maps, boolean[][] visited) {
        visited[y][x] = true;
        count += maps[y].charAt(x) - '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny > maps.length-1 || nx > maps[0].length()-1) {
                continue;
            }
            if (maps[ny].charAt(nx) != 'X' && !visited[ny][nx]) {
                dfs(ny, nx, maps, visited);
            }
        }
    }
}
import java.util.*;

class Solution {
    
    private static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = BFS(maps);
        return answer;
    }
    
    private int BFS(int[][] maps) {
        int count = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            count++;
            
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];

                if (y == n - 1 && x == m - 1) {
                    return count;
                }

                for (int[] dir : dirs) {
                    int ny = y + dir[0];
                    int nx = x + dir[1];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                    if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}
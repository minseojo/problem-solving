import java.util.*;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    class Point {
        int y;
        int x;
        boolean hasKey;
        Point(int y, int x, boolean hasKey) {
            this.y = y;
            this.x = x;
            this.hasKey = hasKey;
        }
    }
    
    public int solution(String[] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    private int bfs(String[] maps) {
        int result = 0;
        Queue<Point> q = new LinkedList<>();
        int[][][] visited = new int[2][maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    q.add(new Point(i, j, false));
                    visited[0][i][j] = 1;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            while (size-- > 0) {
                Point p = q.poll();
                int y = p.y;
                int x = p.x;
                boolean hasKey = p.hasKey;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny > maps.length - 1 || nx > maps[0].length() - 1) {
                        continue;
                    }
                    
                    if (!hasKey && visited[0][ny][nx] == 0 && maps[ny].charAt(nx) != 'X') {
                        visited[0][ny][nx] = result;
                        if (maps[ny].charAt(nx) == 'O') {
                            q.add(new Point(ny, nx, hasKey));
                        } else if (maps[ny].charAt(nx) == 'L') {
                            q.add(new Point(ny, nx, true));
                        } else if (maps[ny].charAt(nx) == 'E') {
                            q.add(new Point(ny, nx, hasKey));
                        } else {
                            q.add(new Point(ny, nx, hasKey));
                        }
                    }
                    if (hasKey && visited[1][ny][nx] == 0 && maps[ny].charAt(nx) != 'X') {
                        visited[1][ny][nx] = result;
                        if (maps[ny].charAt(nx) == 'O') {
                            q.add(new Point(ny, nx, hasKey));
                        } else if (maps[ny].charAt(nx) == 'L') {
                            q.add(new Point(ny, nx, hasKey));
                        } else if (maps[ny].charAt(nx) == 'E') {
                            q.add(new Point(ny, nx, hasKey));
                        } else {
                            q.add(new Point(ny, nx, hasKey));
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'E') {
                    if (visited[1][i][j] != 0) {
                        return visited[1][i][j];
                    }
                }
            }
        }
        return -1;
    }
    
}
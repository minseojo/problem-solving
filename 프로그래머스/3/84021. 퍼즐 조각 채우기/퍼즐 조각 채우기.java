import java.util.*;

class Solution {
    
    class Point implements Comparable<Point> {
        int y;
        int x;
        
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.y == p.y) {
                return Integer.compare(this.x, p.x);
            }
            
            return Integer.compare(this.y, p.y);
        }
    }
    
    final int[] dy = {1, -1, 0, 0};
    final int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<List<Point>> tablePointList = findPointList(table, 1);
        List<List<Point>> emptyPointList = findPointList(game_board, 0);
        
        for (int i = tablePointList.size() - 1; i >= 0; i--) {
            List<Point> tablePoints = tablePointList.get(i);
            for (int j = emptyPointList.size() - 1; j >= 0; j--) {
                List<Point> emptyPoints = emptyPointList.get(j);
                
                if (tablePoints.size() == emptyPoints.size() && isRotate(tablePoints, emptyPoints)) {
                    answer += tablePoints.size();
                    emptyPointList.remove(emptyPoints);
                    break;
                }
            }
        }
        return answer;
    }
    
    private boolean isRotate(List<Point> tablePoints, List<Point> emptyPoints) {
        int size = tablePoints.size();
        
        for (int i = 0; i < 4; i++) {
            int zeroY = tablePoints.get(0).y;
            int zeroX = tablePoints.get(0).x;
			
            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (int j = 0; j < size; j++) {
                tablePoints.get(j).y -= zeroY;
                tablePoints.get(j).x -= zeroX;
            }
			
            boolean isOk = true;
            for (int j = 0; j < size; j++) {
                Point tablePoint = tablePoints.get(j);
                Point emptyPoint = emptyPoints.get(j);
				
                if (tablePoint.y != emptyPoint.y || tablePoint.x != emptyPoint.x) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) return true;

			// 90도 회전 : (y, x) -> (-x, y)
            for (int j = 0; j < tablePoints.size(); j++) {
                int temp = tablePoints.get(j).y;
                tablePoints.get(j).y = -tablePoints.get(j).x;
                tablePoints.get(j).x = temp;
            }

            Collections.sort(tablePoints);            
        }
		
        return false;
    }
    
    private List<List<Point>> findPointList(int[][] table, int target) {
        boolean[][] visited = new boolean[table.length][table[0].length];
        List<List<Point>> pointList = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == target && !visited[i][j]) {
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(0, 0));
                    dfs(table, visited, target, i, j, i, j, points);
                    Collections.sort(points);
                    pointList.add(points);
                }
            }
        }
        
        return pointList;
    }
    
    private void dfs(int[][] table, boolean[][] visited, int target, int y, int x, int sy, int sx, List<Point> points) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny > table.length - 1 || nx > table[0].length - 1) continue;
            if (table[ny][nx] == target && !visited[ny][nx]) {
                points.add(new Point(ny - sy, nx - sx));
                dfs(table, visited, target, ny, nx, sy, sx, points);
            }
        }
    }
}
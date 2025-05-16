import java.util.*;

class Solution {
    
    private static int MIN = -5;
    private static int MAX = 5;
    
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        Set<String> visitedEdges = new HashSet<>();

        int y = 0, x = 0;
        for (char dir : dirs.toCharArray()) {
            int ny = 0, nx = 0;
            if (dir == 'U') {
                ny = y - 1;
                nx = x;
            } else if (dir == 'D') {
                ny = y + 1;
                nx = x;
            } else if (dir == 'R') {
                ny = y;
                nx = x + 1;
            } else if (dir == 'L') {
                ny = y;
                nx = x - 1;
            }
            
            if (ny < MIN || nx < MIN || ny > MAX || nx > MAX) continue;
            
            Point node = new Point(ny, nx);
            String edge1 = x + "," + y + ">" + nx + "," + ny;
            String edge2 = nx + "," + ny + ">" + x + "," + y;
            if (!visitedEdges.contains(edge1) && !visitedEdges.contains(edge2)) {
                answer++;
            }
            
            visitedEdges.add(edge1);
            visitedEdges.add(edge2);
            
            y = ny;
            x = nx;
        }
        
        return answer;
    }
}
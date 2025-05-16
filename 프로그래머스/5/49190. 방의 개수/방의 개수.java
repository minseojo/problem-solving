import java.util.*;

class Solution {
    static int[][] dirs = {
        {0, 1}, {1, 1}, {1, 0}, {1, -1},
        {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };

    static class Point {
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

    public int solution(int[] arrows) {
        Set<Point> visitedNodes = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();

        int x = 0, y = 0;
        Point curr = new Point(x, y);
        visitedNodes.add(curr);
        int answer = 0;

        for (int dirIdx : arrows) {
            int[] dir = dirs[dirIdx];
            // 두 번 이동 (0.5 간격 체크)
            for (int step = 0; step < 2; step++) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                Point next = new Point(nx, ny);

                // 간선 문자열 표현
                String edge1 = x + "," + y + "->" + nx + "," + ny;
                String edge2 = nx + "," + ny + "->" + x + "," + y;

                // 이미 방문한 정점인데 처음 지나는 간선이면 방 생김
                if (visitedNodes.contains(next) && !visitedEdges.contains(edge1)) {
                    answer++;
                }

                visitedNodes.add(next);
                visitedEdges.add(edge1);
                visitedEdges.add(edge2);

                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}

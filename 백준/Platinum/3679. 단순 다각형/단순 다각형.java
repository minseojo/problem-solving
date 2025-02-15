import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static class Point {
        int x;
        int y;
        int index;

        Point() {
            this.x = -1;
            this.y = -1;
            this.index = -1;
        }

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points.add(new Point(x, y, i));
            }
            points.sort((p1, p2) -> {
                if (p1.x == p2.x) return Integer.compare(p1.y, p2.y);
                return Integer.compare(p1.x, p2.x);
            });

            List<Point> lower = new ArrayList<>();
            List<Point> upper = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                while (lower.size() >= 2 && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), points.get(i)) < 0) {
                    lower.remove(lower.size() - 1);
                }
                lower.add(points.get(i));
            }

            lower.remove(lower.size() - 1);

            StringBuilder result = new StringBuilder();
            Set<Integer> check = new HashSet<>();
            for (Point point : lower) {
                result.append(point.index).append(" ");
                check.add(point.index);
            }
            for (int i = n - 1; i >= 0; i--) {
                if (!check.contains(points.get(i).index)) {
                    result.append(points.get(i).index).append(" ");
                }
            }

            System.out.println(result.toString());
        }
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (long) (p2.x - p1.x) * (p3.y - p2.y) - (long) (p2.y - p1.y) * (p3.x - p2.x);
        if (result == 0) return 0;
        else if (result > 0) return 1;
        return -1;
    }

}

/*
1
9 4 4 -4 4 4 -4 -2 -2 2 2 -1 -1 0 0 -4 -4 1 1
*/
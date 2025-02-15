import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double result = 0;

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        points.sort((p1, p2) -> {
            if (p1.x == p2.x) return Integer.compare(p1.y, p2.y);
            return Integer.compare(p1.x, p2.x);
        });

        List<Point> convexHull = initConvexHull(points);
        for (int i = 0; i < convexHull.size(); i++) {
            int j = (i + 1) % convexHull.size();
            result += getDistance(convexHull.get(i), convexHull.get(j));
        }
        result += Math.PI * 2 * l;
        System.out.println(Math.round(result));
    }

    // 반시계 방향으로 컨벡스헐 구성
    static List<Point> initConvexHull(List<Point> points) {
        List<Point> convexHull = new ArrayList<>();
        List<Point> lower = new ArrayList<>();
        List<Point> upper = new ArrayList<>();

        for (int i = 0 ; i < points.size() ; i++) {
            while (lower.size() >= 2 && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), points.get(i)) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(points.get(i));
        }

        for (int i = points.size() - 1 ; i >= 0; i--) {
            while (upper.size() >= 2 && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), points.get(i)) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(points.get(i));
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        convexHull.addAll(lower);
        convexHull.addAll(upper);
        return convexHull;
    }

    static long ccw(Point p1, Point p2, Point p3) {
        return (long) (p2.x - p1.x) * (p3.y - p2.y) - (long) (p3.x - p2.x) * (p2.y - p1.y);
    }

    static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y -p1.y, 2));
    }

}
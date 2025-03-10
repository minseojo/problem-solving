import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int c = Integer.parseInt(br.readLine());
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < c; i++) {
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

            double maxDistance = 0.0;
            Point[] maxDistanceTwoPoint = new Point[2];
            int j = 1;
            Point temp = new Point(0, 0);
            for (int i = 0; i < convexHull.size(); i++) {
                int iNext = (i + 1) % convexHull.size();
                while (true) {
                    int jNext = (j + 1) % convexHull.size();

                    Point iVector = new Point(convexHull.get(iNext).x - convexHull.get(i).x,
                            convexHull.get(iNext).y - convexHull.get(i).y);
                    Point jVector = new Point(convexHull.get(jNext).x - convexHull.get(j).x,
                            convexHull.get(jNext).y - convexHull.get(j).y);

                    if (ccw(temp, iVector, jVector) > 0) j = jNext;
                    else break;
                }
                double distance = getDistance(convexHull, i, j);
                if (maxDistance < distance) {
                    maxDistance = distance;
                    maxDistanceTwoPoint[0] = convexHull.get(i);
                    maxDistanceTwoPoint[1] = convexHull.get(j);
                }

            }
            result.append(maxDistanceTwoPoint[0].x).append(" ").append(maxDistanceTwoPoint[0].y);
            result.append(" ");
            result.append(maxDistanceTwoPoint[1].x).append(" ").append(maxDistanceTwoPoint[1].y);
            result.append("\n");
        }

        System.out.println(result.toString());
    }

    static List<Point> initConvexHull(List<Point> points) {
        List<Point> lower = new ArrayList<>();
        List<Point> upper = new ArrayList<>();

        for (int j = 0; j < points.size(); j++) {
            while (lower.size() >= 2 && ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), points.get(j)) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(points.get(j));
        }

        for (int j = points.size() - 1; j >= 0; j--) {
            while (upper.size() >= 2 && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), points.get(j)) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(points.get(j));
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        List<Point> convexHull = new ArrayList<>();
        convexHull.addAll(lower);
        convexHull.addAll(upper);

        return convexHull;
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (long) (p2.x - p1.x) * (p3.y - p2.y) - (long) (p2.y - p1.y) * (p3.x - p2.x);
        if (result == 0) return 0;
        else if (result > 0) return 1;
        return -1;
    }

    static double getDistance(List<Point> points, int i, int j) {
        return Math.sqrt(
                Math.pow(points.get(i).x - points.get(j).x, 2) +
                Math.pow(points.get(i).y - points.get(j).y, 2)
        );
    }

}

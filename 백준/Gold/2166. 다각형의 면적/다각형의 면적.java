import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer coordinate = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(coordinate.nextToken());
            int y = Integer.parseInt(coordinate.nextToken());
            points[i] = new Point(x, y);
        }
        points[n] = new Point(points[0].x, points[0].y);

        double polygonArea = 0;
        for (int i = 0; i < n; i++) {
            polygonArea += shoelaceFormula(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
        }
        polygonArea = (double) Math.abs(Math.round(polygonArea * 100)) / 100 / 2;
        System.out.printf("%.1f%n", polygonArea);
    }

    static double shoelaceFormula(double x1, double y1, double x2, double y2) {
        return (x1 * y2) - (y1 * x2);
    }
}
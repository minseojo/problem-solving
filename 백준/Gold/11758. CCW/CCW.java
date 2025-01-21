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
        StringTokenizer coordinate = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(coordinate.nextToken()), Integer.parseInt(coordinate.nextToken()));
        coordinate = new StringTokenizer(br.readLine());
        Point p2 = new Point(Integer.parseInt(coordinate.nextToken()), Integer.parseInt(coordinate.nextToken()));
        coordinate = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(coordinate.nextToken()), Integer.parseInt(coordinate.nextToken()));

        double ccw = counterClockWise(p1, p2, p3);
        if (ccw == 0) System.out.println(0);
        else if (ccw > 0) System.out.println(1);
        else System.out.println(-1);
    }

    static double counterClockWise(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y -p2.y) - (p2.y - p1.y) * (p3.x - p2.x) +
            (p3.x - p2.x) * (p1.y - p3.y) - (p3.y - p2.y) * (p1.x - p3.x) +
                (p1.x - p3.x) * (p2.y - p1.y) - (p1.y - p3.y) * (p2.x - p1.x);
    }
}
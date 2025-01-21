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

    static class Circle {
        int x;
        int y;
        int radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int result = 0;
            StringTokenizer coordinates = new StringTokenizer(br.readLine());
            // 출발지
            Point A = new Point(Integer.parseInt(coordinates.nextToken()), Integer.parseInt(coordinates.nextToken()));
            // 도착지
            Point B = new Point(Integer.parseInt(coordinates.nextToken()), Integer.parseInt(coordinates.nextToken()));
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer circleParameters = new StringTokenizer(br.readLine());
                // 중점
                Circle O = new Circle(
                        Integer.parseInt(circleParameters.nextToken()),
                        Integer.parseInt(circleParameters.nextToken()),
                        Integer.parseInt(circleParameters.nextToken())
                );

                double lineOA = Math.sqrt(Math.pow(A.x - O.x, 2) + Math.pow(A.y - O.y, 2));
                double lineOB = Math.sqrt(Math.pow(B.x - O.x, 2) + Math.pow(B.y - O.y, 2));
                if (lineOA < O.radius && lineOB >= O.radius || lineOB < O.radius && lineOA >= O.radius) {
                    result++;
                }
            }

            System.out.println(result);
        }

    }
}
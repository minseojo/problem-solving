import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    static Point add(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }

    static Point subtract(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y);
    }

    static long cross(Point p1, Point p2) {
        return p1.x * p2.y - p1.y * p2.x;
    }

    static long dot(Point p1, Point p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

    static long distanceSquared(Point p1, Point p2) {
        long dx = p1.x - p2.x;
        long dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    static double perpendicularDistance(Point p, Point q, Point dir) {
        Point r = add(p, dir);
        return Math.abs(cross(subtract(q, p), subtract(r, p))) / Math.sqrt(distanceSquared(p, r));
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int testcase = 0; testcase < T; testcase++) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0L;
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                while (!pq.isEmpty() && pq.peek() < x) {
                    sum += (x - pq.poll());
                    pq.add(x);
                }

                pq.add(x);
            }
            answer.append(sum).append("\n");
        }
        
        System.out.println(answer.toString());
        br.close();
    }

}

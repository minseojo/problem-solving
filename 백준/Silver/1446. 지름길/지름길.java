import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point>{
        int position;
        int cost;

        Point(int position, int cost) {
            this.position = position;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Point>[] graph = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (end <= 10000) {
                graph[start].add(new Point(end, distance));
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int currentPos = current.position;
            int currentCost = current.cost;

            if (dist[currentPos] < currentCost) continue;

            for (Point neighbor : graph[currentPos]) {
                int nextPos = neighbor.position;
                int newCost = currentCost + neighbor.cost;

                if (newCost < dist[nextPos]) {
                    dist[nextPos] = newCost;
                    pq.add(new Point(nextPos, newCost));
                }
            }

            if (currentPos + 1 <= 10000 && currentCost + 1 < dist[currentPos + 1]) {
                dist[currentPos + 1] = currentCost + 1;
                pq.add(new Point(currentPos + 1, currentCost + 1));
            }
        }

        System.out.println(dist[d]);
    }
}

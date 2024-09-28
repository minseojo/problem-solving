import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static class Point {
        int y;
        int x;
        int dir;
        int count;

        Point(int y, int x, int dir, int count) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.count = count;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n  = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        Queue<Point> q = new PriorityQueue<>((Point p1, Point p2) -> {
            return Integer.compare(p1.count, p2.count);
        });
        int[][][] visited = new int[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = 987654321;
                }
            }
        }

        int ey = -1, ex = -1;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c =  s.charAt(j);
                if (c == '.') graph[i][j] = 0;
                if (c == 'C') graph[i][j] = 1;
                if (c == '*') graph[i][j] = -1;
            }
        }

        boolean isFirst = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && isFirst) {
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if (graph[ny][nx] == -1) continue;
                        visited[ny][nx][k] = 0;
                        q.add(new Point(ny, nx, k, 0));
                    }
                    isFirst = false;
                } else if (graph[i][j] == 1 && !isFirst) {
                    ey = i;
                    ex = j;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                int y = p.y;
                int x = p.x;
                int dir = p.dir;
                int count = p.count;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if (graph[ny][nx] == -1) continue;

                    if (dir != i) {
                        if (visited[ny][nx][i] > count + 1) {
                            q.add(new Point(ny, nx, i, count + 1));
                            visited[ny][nx][i] = count + 1;
                        }
                    } else {
                        if (visited[ny][nx][i] > count) {
                            q.add(new Point(ny, nx, i, count));
                            visited[ny][nx][i] = count;
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            result = Math.min(result, visited[ey][ex][k]);
        }
        System.out.println(result);
    }
}

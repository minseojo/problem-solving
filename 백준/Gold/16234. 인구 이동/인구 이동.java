import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; // 북/동/남/서

    static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++)  {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)  {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, l, r, a));
    }

    private static int solution(int n, int l, int r, int[][] a) {
        int result = 0;

        while (true) {
            int openCount = 0;
            boolean[][] visited = new boolean[n + 2][n + 2];
            for (int i = 1; i <= n; i++)  {
                for (int j = 1; j <= n; j++)  {
                    if (!visited[i][j]) {
                        openCount += BFS(n, i, j, l, r, a, visited);
                    }
                }
            }

            if (openCount == 0) break;
            result++;
        }

        return result;
    }

    private static int BFS(int n, int y, int x, int l, int r, int[][] a, boolean[][] visited) {
        visited[y][x] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(y, x));

        int sum = 0;
        List<Coordinate> coordinates = new ArrayList<>();
        while (!q.isEmpty()) {
            Coordinate cur = q.poll();
            int curY = cur.y;
            int curX = cur.x;
            coordinates.add(new Coordinate(curY, curX));
            sum += a[curY][curX];

            for (int[] dir : dirs) {
                int ny = curY + dir[0];
                int nx = curX + dir[1];
                if (ny >= 1 && nx >= 1 && ny <= n && nx <= n && !visited[ny][nx]) {
                    int value = Math.abs(a[ny][nx] - a[curY][curX]);
                    if (l <= value && value <= r) {
                        visited[ny][nx] = true;
                        q.add(new Coordinate(ny, nx));
                    }
                }
            }
        }

        for (Coordinate coordinate : coordinates) {
            a[coordinate.y][coordinate.x] = sum / coordinates.size();
        }

        return coordinates.size() - 1;
    }
}

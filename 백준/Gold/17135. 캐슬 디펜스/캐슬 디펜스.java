import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer;

    static class Point {
        int y;
        int x;

        Point (int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (y != point.y) return false;
            return x == point.x;
        }

        @Override
        public int hashCode() {
            int result = y;
            result = 31 * result + x;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        answer = 0;
        int[][] enemy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                enemy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[m];
        List<Integer> cache = new ArrayList<>();
        dfs(0, 0, visited, cache, n , m, d, enemy);
        System.out.println(answer);
    }

    private static void dfs(int pos, int idx, boolean[] visited, List<Integer> cache, int n, int m, int d, int[][] enemy) {
        if (pos == 3) {
            answer = Math.max(answer, game(n, m, d, cache, enemy));
        }

        for (int i = idx; i < m; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cache.add(i);
            dfs(pos + 1, i + 1, visited, cache, n, m, d, enemy);
            cache.remove((Integer) i);
            visited[i] = false;
        }
    }

    static int[] dy = {0, -1, 0};
    static int[] dx = {-1, 0, 1};

    private static int game(int n, int m, int d, List<Integer> cache, int[][] enemy) {
        int result = 0;

        int[][] temp = new int[enemy.length][enemy[0].length];
        for (int i = 0; i < enemy.length; i++) {
            for (int j = 0; j < enemy[0].length; j++) {
                temp[i][j] = enemy[i][j];
            }
        }


        for (int i  = n - 1; i >= 0; i--) {
            Set<Point> shout = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                int sy = i;
                int sx = cache.get(j);
                attackEnemy(n, m, d, sy, sx, temp, shout);
            }

            for (Point p : shout) {
                int y = p.y;
                int x = p.x;
                temp[y][x] = 0;
                result++;
            }
        }

        return result;
    }

    private static void attackEnemy(int n, int m, int d, int sy, int sx,
                                    int[][] temp, Set<Point> shout) {
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sy, sx));
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                int y = p.y;
                int x = p.x;
                if (temp[y][x] == 1 && sy-y+1 + Math.abs(sx-x) <= d) {
                    shout.add(new Point(y, x));
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny > n-1 || nx > m-1) continue;
                    if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    q.add(new Point(ny, nx));
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Normal moves
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1} // Knight moves
    };

    static int k, n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k + 1];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[0][0] == 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        BFS(0, 0);

        int distance = result[n - 1][m - 1];
        if (distance == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result[n - 1][m - 1]);
    }

    static void BFS(int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sy, sx, 0, k});
        visited[sy][sx][k] = true;

        result[sy][sx] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int count = cur[2];
            int kSize = cur[3];

            if (y == n - 1 && x == m - 1) return;

            for (int i = 0; i < dir.length; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 1) continue;

                if (i < 4) {
                    if (!visited[ny][nx][kSize]) {
                        visited[ny][nx][kSize] = true;
                        result[ny][nx] = count + 1;
                        q.add(new int[]{ny, nx, count + 1, kSize});
                    }
                } else {
                    if (kSize > 0 && !visited[ny][nx][kSize - 1]) {
                        visited[ny][nx][kSize - 1] = true;
                        result[ny][nx] = count + 1;
                        q.add(new int[]{ny, nx, count + 1, kSize - 1});
                    }
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, n, m;
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1, 2, -2, 2, -2};
    static int[] dx = {0, 0, 1, -1, 2, 2, -2, -2, 1, 1, -1, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][k +1];
        q.add(new int[] {0, 0, 0});
        visited[0][0][0] = true;

        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int now[] = q.poll();
                int y = now[0];
                int x = now[1];
                int count = now[2];

                if(y == n - 1 && x == m - 1) return depth;

                for(int dir = 0; dir < 12; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    int nextCount = count;

                    if (dir >= 4) {
                        if (nextCount + 1 > k) continue;
                        nextCount++;
                    }
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx][nextCount]) continue;
                    if (map[ny][nx] == 1) continue;
                    visited[ny][nx][nextCount] = true;
                    q.add(new int[] {ny, nx, nextCount});
                }
            }
            depth++;
        }

        return -1;
    }
}

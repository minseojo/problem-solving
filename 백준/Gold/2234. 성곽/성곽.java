import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] a;

    static int LEFT = 1;
    static int UP = 2;
    static int RIGHT = 4;
    static int DOWN = 8;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                a[i][j] = x;
            }
        }

        int roomCount = 0;
        int maxRoomArea = 0;
        int maxRoomAreaByWallRemoval = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    roomCount++;
                    maxRoomArea = Math.max(maxRoomArea, dfs(i, j, visited));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((a[i][j] & LEFT) == LEFT) maxRoomAreaByWallRemoval = Math.max(maxRoomAreaByWallRemoval, dfsByWallRemoval(i, j, LEFT));
                if ((a[i][j] & UP) == UP) maxRoomAreaByWallRemoval = Math.max(maxRoomAreaByWallRemoval, dfsByWallRemoval(i, j, UP));
                if ((a[i][j] & RIGHT) == RIGHT) maxRoomAreaByWallRemoval = Math.max(maxRoomAreaByWallRemoval, dfsByWallRemoval(i, j, RIGHT));
                if ((a[i][j] & DOWN) == DOWN) maxRoomAreaByWallRemoval = Math.max(maxRoomAreaByWallRemoval, dfsByWallRemoval(i, j, DOWN));
            }
        }

        System.out.println(roomCount);
        System.out.println(maxRoomArea);
        System.out.println(maxRoomAreaByWallRemoval);
    }

    static int dfs(int y , int x, boolean[][] visited) {
        visited[y][x] = true;

        int result = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (i == 0 && (a[y][x] & LEFT) == LEFT) continue;
            if (i == 1 && (a[y][x] & UP) == UP) continue;
            if (i == 2 && (a[y][x] & RIGHT) == RIGHT) continue;
            if (i == 3 && (a[y][x] & DOWN) == DOWN) continue;
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
            result = dfs(ny, nx, visited) + result;
        }

        return result;
    }

    static int dfsByWallRemoval(int y, int x, int wall) {
        a[y][x] -= wall;
        int result = dfs(y, x, new boolean[n][m]);
        a[y][x] += wall;
        
        return result;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0 ,0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfs(0, 0, map, memo);
        System.out.println(memo[0][0]);
    }

    static int dfs(int y, int x, int[][] map, int[][] memo) {
        if (y == map.length - 1 && x == map[0].length - 1) {
            return 1;
        }

        if (memo[y][x] != -1) return memo[y][x];

        int result = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) continue;
            if (map[ny][nx] < map[y][x]) {
                result += dfs(ny, nx, map, memo);
            }
        }

        return memo[y][x] = result;
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] a;
    static int[][] flower = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, new boolean[n][n], 0);

        System.out.println(answer);
    }

    static void dfs(int pos, boolean[][] visited, int sum) {
        if (pos == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isOk = true;
                for (int k = 0; k < flower.length; k++) {
                    int y = i + flower[k][0], x = j + flower[k][1];
                    if (y < 0 || y >= n || x < 0 || x >= n || visited[y][x]) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) continue;
                for (int k = 0; k < flower.length; k++) {
                    int y = i + flower[k][0], x = j + flower[k][1];
                    if (y < 0 || y >= n || x < 0 || x >= n) continue;

                    visited[y][x] = true;
                    sum += a[y][x];
                }
                dfs(pos + 1, visited, sum);
                for (int k = 0; k < flower.length; k++) {
                    int y = i + flower[k][0], x = j + flower[k][1];
                    if (y < 0 || y >= n || x < 0 || x >= n) continue;
                    visited[y][x] = false;
                    sum -= a[y][x];
                }
            }
        }
    }

}

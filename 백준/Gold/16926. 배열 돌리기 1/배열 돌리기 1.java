import java.io.*;
import java.util.*;

public class Main {

    // 왼쪽, 아래, 오른쪽, 위
    static int[][] dirs = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer + 1;
            int left = layer + 1;
            int bottom = n - layer;
            int right = m - layer;

            // 현재 링의 둘레 길이 (사각형 테두리 칸 수)
            int L = 2 * ((bottom - top) + (right - left));
            if (L == 0) continue;

            int k = r % L;  // 필요한 만큼만 회전

            while (k-- > 0) {
                int y = top, x = right;    // 시작점: (top, right)
                int temp = a[y][x];
                int temp2;

                for (int[] dir : dirs) {
                    while (true) {
                        int ny = y + dir[0];
                        int nx = x + dir[1];
                        if (ny < top || nx < left || ny > bottom || nx > right) break;
                        temp2 = a[ny][nx];
                        a[ny][nx] = temp;
                        temp = temp2;
                        y = ny;
                        x = nx;
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                out.append(a[i][j]).append(' ');
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}

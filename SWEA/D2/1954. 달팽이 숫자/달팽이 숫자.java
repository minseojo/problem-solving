import java.io.*;

public class Solution {

    static int[] dy = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcc; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];

            int y = 0;
            int x = 0;
            int dir = 0;
            int count = 1;

            while (count < n * n + 1) {
                a[y][x] = count++;

                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || nx < 0 || ny > n - 1 || nx > n - 1 || a[ny][nx] != 0) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }

                y = ny;
                x = nx;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
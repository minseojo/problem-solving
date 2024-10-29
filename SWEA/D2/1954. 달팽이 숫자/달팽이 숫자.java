import java.io.*;

public class Solution {

    static int[] dy = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= tcc; tc++) {
            int n = Integer.parseInt(br.readLine());
            int dir = 0; // 방향
            int count = 1; // 시작 숫자
            int y = 0, x = 0; // 시작 위치
            int[][] a = new int[n][n]; // n x n 배열 생성

            while (count <= n * n) {
                a[y][x] = count++; // 현재 위치에 값 할당
                int ny = y + dy[dir]; // 다음 y 위치
                int nx = x + dx[dir]; // 다음 x 위치

                // 배열 경계를 벗어나거나 이미 값이 할당된 경우 방향 전환
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || a[ny][nx] != 0) {
                    dir = (dir + 1) % 4; // 방향 전환
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

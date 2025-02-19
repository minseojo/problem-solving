import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];

        for (int i = 0; i < k; i++) {
            int nx = x, ny = y;
            int move = Integer.parseInt(st.nextToken());
            int[] temp = Arrays.copyOf(dice, dice.length);
            if (move == 1) { // 동
                if (nx + 1 >= m) continue;
                nx++;
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[3] = temp[2];
                dice[5] = temp[3];
            } else if (move == 2) { // 서
                if (nx - 1 < 0) continue;
                nx--;
                dice[1] = temp[2];
                dice[2] = temp[3];
                dice[3] = temp[5];
                dice[5] = temp[1];
            } else if (move == 3) { // 북
                if (ny - 1 < 0) continue;
                ny--;
                dice[0] = temp[2];
                dice[2] = temp[4];
                dice[4] = temp[5];
                dice[5] = temp[0];
            } else if (move == 4) { // 남
                if (ny + 1 >= n) continue;
                ny++;
                dice[0] = temp[5];
                dice[2] = temp[0];
                dice[4] = temp[2];
                dice[5] = temp[4];
            }
            result.append(dice[2]).append("\n");
            x = nx;
            y = ny;
            if (a[y][x] == 0) a[y][x] = dice[5];
            else {
                dice[5] = a[y][x];
                a[y][x] = 0;
            }
        }

        System.out.println(result.toString());
        br.close();
    }

}

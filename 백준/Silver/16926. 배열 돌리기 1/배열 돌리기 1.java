import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-- > 0) {
            int y = 1;
            int x = m;
            int temp = a[y][x];
            int temp2;
            int yDirSize = n-1;
            int xDirSize = m-1;

            while (yDirSize > 0 && xDirSize > 0) {
                for (int i = 0; i < xDirSize; i++) {
                    temp2 = a[y][x-1];
                    a[y][--x] = temp;
                    temp = temp2;
                }

                for (int i = 0; i < yDirSize; i++) {
                    temp2 = a[y+1][x];
                    a[++y][x] = temp;
                    temp = temp2;
                }

                for (int i = 0; i < xDirSize; i++) {
                    temp2 = a[y][x+1];
                    a[y][++x] = temp;
                    temp = temp2;
                }
                xDirSize -= 2;

                for (int i = 0; i < yDirSize; i++) {
                    temp2 = a[y-1][x];
                    a[--y][x] = temp;
                    temp = temp2;
                }
                yDirSize -= 2;

                y++;
                x--;
                temp = a[y][x];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

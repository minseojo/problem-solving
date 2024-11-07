import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int n, k;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcc; tc++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = new int[n + k + 1][n + k + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][j - 1] != 1 && checkX(i, j)) answer++;
                    if (a[i - 1][j] != 1 && checkY(i, j)) answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static boolean checkX(int y, int x) {
        for (int i = x; i < x + k; i++) {
            if (a[y][i] != 1) return false;
        }
        
        return a[y][x + k] == 0;
    }

    static boolean checkY(int y, int x) {
        for (int i = y; i < y + k; i++) {
            if (a[i][x] != 1) return false;
        }

        return a[y + k][x] == 0;
    }
    
}
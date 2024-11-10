import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = 9;
        for (int tc = 1; tc <= T; tc++) {
            int[][] a = new int[n][n];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + solve(a));
        }
    }

    static int solve(int[][] a) {
        int n = 9;

        for (int i = 0; i < 9; i++) {
            int[] check = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int x = a[i][j];
                if (check[x] >= 1) return 0;
                check[x]++;
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] check = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int x = a[j][i];
                if (check[x] >= 1) return 0;
                check[x]++;
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] check = new int[n + 1];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (check[a[k][l]] >= 1) {
                            return 0;
                        }
                        check[a[k][l]]++;
                    }
                }
            }
        }

        return 1;
    }
}
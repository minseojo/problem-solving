import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] memo = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            if (memo[a + 50][b + 50][c + 50] != 0) {
                System.out.printf("w(%d, %d, %d) = " + memo[a + 50][b + 50][c + 50] + "\n", a, b, c);
            } else {
                w(a, b, c);
                System.out.printf("w(%d, %d, %d) = " + memo[a + 50][b + 50][c + 50] + "\n", a, b, c);
            }
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return memo[a + 50][b + 50][c + 50] = 1;
        }

        if (memo[a + 50][b + 50][c + 50] != 0) return memo[a + 50][b + 50][c + 50];

        if (a > 20 || b > 20 || c > 20) {
            return memo[a + 50][b + 50][c + 50] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return memo[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return memo[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}

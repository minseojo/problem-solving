import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] a = new char[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                a[i][j] = s.charAt(j - 1);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                answer = Math.max(answer, findCandies(deepCopy(a)));
                if (j > 1) answer = Math.max(answer, findCandies(leftSwap(deepCopy(a), i, j)));
                if (j + 1 <= n) answer = Math.max(answer, findCandies(rightSwap(deepCopy(a), i, j)));
                if (i > 1) answer = Math.max(answer, findCandies(upSwap(deepCopy(a), i, j)));
                if (i + 1 <= n) answer = Math.max(answer, findCandies(downSwap(deepCopy(a), i, j)));
            }
        }

        System.out.println(answer);
    }

    static char[][] leftSwap(char[][] a, int i, int j) {
        char temp = a[i][j];
        a[i][j] = a[i][j - 1];
        a[i][j - 1] = temp;
        return a;
    }

    static char[][] rightSwap(char[][] a, int i, int j) {
        char temp = a[i][j];
        a[i][j] = a[i][j + 1];
        a[i][j + 1] = temp;
        return a;
    }

    static char[][] upSwap(char[][] a, int i, int j) {
        char temp = a[i][j];
        a[i][j] = a[i - 1][j];
        a[i - 1][j] = temp;
        return a;
    }

    static char[][] downSwap(char[][] a, int i, int j) {
        char temp = a[i][j];
        a[i][j] = a[i + 1][j];
        a[i + 1][j] = temp;
        return a;
    }

    static int findCandies(char[][] a) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int rowCount = 1;
                int nx = j;
                while (nx + 1 < n + 1 && a[i][nx] == a[i][nx + 1]) {
                    rowCount++;
                    nx++;
                }

                int columnCont = 1;
                int ny = i;
                while (ny + 1 < n + 1 && a[ny][j] == a[ny + 1][j]) {
                    columnCont++;
                    ny++;
                }

                result = Math.max(result, rowCount);
                result = Math.max(result, columnCont);
            }
        }

        return result;
    }

    static char[][] deepCopy(char[][] a) {
        char[][] copy = new char[a.length][];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i].clone();
        }
        return copy;
    }

}

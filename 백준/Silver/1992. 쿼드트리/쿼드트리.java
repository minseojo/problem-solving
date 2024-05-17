import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(f(a, n, 0, 0));
    }

    private static String f(int[][] a, int size, int sy, int sx) {
        int zeroCnt = 0;
        for (int i = sy; i < sy + size; i++) {
            for (int j = sx; j < sx + size; j++) {
                if (a[i][j] == 0) zeroCnt++;
            }
        }

        StringBuilder result = new StringBuilder();
        if (zeroCnt == 0) {
            return "1";
        } else if (size * size == zeroCnt) {
            return "0";
        } else {
            size /= 2;
            result.append("(");
            result.append(f(a, size, sy, sx));
            result.append(f(a, size, sy, sx + size));
            result.append(f(a, size, sy + size, sx));
            result.append(f(a, size, sy + size, sx + size));
            result.append(")");
        }

        return result.toString();
    }

}

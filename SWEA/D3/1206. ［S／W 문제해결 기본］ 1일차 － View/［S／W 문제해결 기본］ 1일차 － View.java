import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < n - 2 ; i++) {
                boolean isLeft = true;
                boolean isRight = true;
                if (a[i] < a[i - 1] || a[i] < a[i - 2]) isLeft = false;
                if (a[i] < a[i + 1] || a[i] < a[i + 2]) isRight = false;
                if (isLeft && isRight) {
                    int maxLeft = Math.max(a[i - 1], a[i - 2]);
                    int maxRight = Math.max(a[i + 1], a[i + 2]);
                    answer += (a[i] - Math.max(maxLeft, maxRight));
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

}
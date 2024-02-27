import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i + 1] > a[i + 2]) {
                int x = Math.min(a[i], a[i + 1] - a[i + 2]);
                answer += (5 * x);
                a[i] -= x;
                a[i + 1] -= x;

                x = Math.min(a[i], Math.min(a[i + 1], a[i + 2]));
                answer += (7 * x);
                a[i] -= x;
                a[i + 1] -= x;
                a[i + 2] -= x;
            } else {
                int x = Math.min(a[i], Math.min(a[i + 1], a[i + 2]));
                answer += (7 * x);
                a[i] -= x;
                a[i + 1] -= x;
                a[i + 2] -= x;

                x = Math.min(a[i], a[i + 1]);
                answer += (5 * x);
                a[i] -= x;
                a[i + 1] -= x;
            }
            answer += (a[i] * 3);
            a[i] = 0;
        }

        System.out.println(answer);
    }
}

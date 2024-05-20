import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] cost = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            // 0 ~l, 0~l+1, 0~l+2, ..., 0~n
            // 1~l+1, 1~l+2, 1~l+3
            // 2~l+2, 2~l+3
            // 3~l+3, 3~l+4
            double result = 1000 * 1000 * 100.0;
            for (int k = l; k <= n; k++) {
                for (int i = 0; i <= n - k; i++) {
                    double sum = 0;
                    for (int j = i; j < i + k; j++) {
                        sum += cost[j];
                    }
                    result = Math.min(result, sum / k);
                }
            }
            System.out.printf("%.12f\n", result);
        }
    }
}

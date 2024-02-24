import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long[] dist = new long[n - 1];
        long[] cost = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = cost[0];
        for (int i = 1; i < n; i++) {
            if (minCost > cost[i]) {
                minCost = cost[i];
            }

            cost[i] = minCost;
        }

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += cost[i] * dist[i];
        }
        System.out.println(answer);
    }
}

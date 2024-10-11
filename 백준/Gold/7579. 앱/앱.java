import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int n, m;
    static List<App> apps;
    static int[][] cache;
    static class App {
        int memory;
        int cost;

        App(int memory) {
            this.memory = memory;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        apps = new ArrayList<>();
        cache = new int[n][10001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apps.add(new App(Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apps.get(i).cost = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= 10000; i++) {
            if (topDown(0, i) >= m) {
                System.out.println(i);
                break;
            }
        }
    }

    static int topDown(int here, int cost) {
        if (here >= n) return 0;
        if (cache[here][cost] != -1) return cache[here][cost];
        cache[here][cost] = topDown(here + 1, cost);
        if (cost >= apps.get(here).cost) {
            cache[here][cost] = Math.max(cache[here][cost],
                    topDown(here + 1, cost - apps.get(here).cost) + apps.get(here).memory);
        }
        return cache[here][cost];
    }

}

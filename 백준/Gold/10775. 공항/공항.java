import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= P; i++) {
            int p = Integer.parseInt(br.readLine());
            int tmp = find(parent, p);
            if (tmp == 0) {
                break;
            }

            result++;
            union(parent, tmp, tmp - 1);
        }

        System.out.println(result);
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int u, int v) {
        u = find(parent, u);
        v = find(parent, v);
        if (u != v) parent[u] = v;
    }

}

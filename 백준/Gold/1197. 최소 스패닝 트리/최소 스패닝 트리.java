import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> Integer.compare(i[2], j[2]));
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
        }

        int answer = 0;
        int[] parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int a = top[0];
            int b = top[1];
            int c = top[2];
            if (find(a, parent) != find(b, parent)) {
                merge(a, b, parent);
                answer += c;
            }
        }

        System.out.println(answer);
    }

    static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    static void merge(int u, int v, int[] parent) {
        u = find(u, parent);
        v = find(v, parent);
        if (u > v) parent[u] = v;
        else parent[v] = u;
    }

}

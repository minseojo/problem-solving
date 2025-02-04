import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int a;
        int b;
        int c;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void merge(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a <= b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(node -> node.c));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, c));
        }

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        long result = t * (long) (n - 1) * (n - 2) / 2;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int a =node.a;
            int b =node.b;
            int c =node.c;
            if (find(parent, a) != find(parent, b)) {
                merge(parent, a, b);
                result += c;
            }
        }

        System.out.println(result);
    }
}

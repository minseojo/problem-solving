import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long init(int start, int end, int node, long[] tree, long[] A) {
        if (start == end) return tree[node] = A[start];
        int mid = start + (end - start) / 2;
        return tree[node] = init(start, mid, node * 2, tree, A) +
                init(mid + 1, end , node * 2 + 1, tree, A);
    }

    static long sum (int start, int end, int node, long left, long right, long[] tree) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = start + (end - start) / 2;
        return sum(start, mid, node * 2, left, right, tree) +
                sum(mid + 1, end,  node * 2 + 1, left, right, tree);
    }

    static void update(int start, int end, int node, long changeNode, long diff, long[] tree) {
        if (start > changeNode || changeNode > end) return;

        tree[node] += diff;
        if (start == end) return;

        int mid = start + (end - start) / 2;
        update(start, mid, node * 2, changeNode, diff, tree);
        update(mid + 1, end, node * 2 + 1, changeNode, diff, tree);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] A = new long[n + 1];
        long[] tree = new long[(n + 1) * 4];
        for (int i = 1; i <= n; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1, tree, A);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // 업데이트
            if (a == 1) {
                long diff = c - A[(int) b];
                A[(int) b] = c;
                update(1, n, 1, b, diff, tree);
            }
            // 구간 합 구하기 [b, c]
            else if (a == 2) {
                result.append(sum(1, n, 1, b, c, tree)).append("\n");
            }
        }

        System.out.println(result.toString());
        br.close();
    }

}

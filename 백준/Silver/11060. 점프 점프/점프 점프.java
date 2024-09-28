import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, a[0]});
        visited[0] = 0;

        int result = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] data = q.poll();
                int here = data[0];
                int value = data[1];

                for (int i = 1; i <= value; i++) {
                    int next = here + i;
                    if (next >= n - 1) {
                        System.out.println(result);
                        return;
                    }
                    if (visited[next] == 0) {
                        visited[next] = result;
                        q.add(new int[] {next, a[next]});
                    }
                }
            }
            result++;
        }

        System.out.println(-1);
    }
}

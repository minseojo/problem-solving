import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                if (!q.isEmpty()) {
                    q.add(q.poll());
                }
            }

            sb.append(q.poll());
            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }

}
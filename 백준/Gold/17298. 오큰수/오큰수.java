import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= a[i]) {
                stack.pollLast();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peekLast();
            }

            stack.addLast(a[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}

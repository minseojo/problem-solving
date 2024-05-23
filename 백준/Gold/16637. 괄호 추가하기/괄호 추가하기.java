
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        char[] value = new char[n];
        for (int i = 0; i < s.length(); i++) {
            value[i] = s.charAt(i);
        }

        solve(2, n, value, value[0] - '0');
        System.out.println(result);
    }

    private static void solve(int pos, int n, char[] value, int sum) {
        if (pos >= n) {
            result = Math.max(result, sum);
            return;
        }

        // sum op pos
        solve(pos + 2, n, value, calculate(sum, value[pos] - '0', value[pos - 1]));
        if (pos + 2 < n) {
            // 괄호
            int right = calculate(value[pos] - '0', value[pos + 2] - '0', value[pos + 1]);
            int total = calculate(sum, right, value[pos - 1]);
            solve(pos + 4, n, value, total);
        }
    }

    private static int calculate(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}

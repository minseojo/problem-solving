import java.util.*;
import java.io.*;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers, op, new int[n - 1]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int pos, int[] numbers, int[] op, int[] newOp) {
        if (pos == numbers.length - 1) {
            int sum = numbers[0];
            for (int i = 0; i < newOp.length; i++) {
                if (newOp[i] == 0) {
                    sum += numbers[i + 1];
                } else if (newOp[i] == 1) {
                    sum -= numbers[i + 1];
                } else if (newOp[i] == 2) {
                    sum *= numbers[i + 1];
                } else if (newOp[i] == 3) {
                    sum /= numbers[i + 1];
                }
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;
                newOp[pos] = i;
                dfs(pos + 1, numbers, op, newOp);
                op[i]++;
            }
        }
    }

}
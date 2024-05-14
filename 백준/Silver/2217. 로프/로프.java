import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);
        int[] sum = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = rope[i] / (n - i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result <= rope[i] * (n-i)) {
                result = rope[i] * (n-i);
            }
        }

        System.out.println(result);
    }

}

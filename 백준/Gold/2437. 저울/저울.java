import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] weight = new int[1001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight, 0, n);
        if (weight[0] != 1) {
            System.out.println(1);
        } else {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += weight[i];
                if (sum + 1 < weight[i + 1]) break;
            }
            System.out.println(sum + 1);
        }
    }
}

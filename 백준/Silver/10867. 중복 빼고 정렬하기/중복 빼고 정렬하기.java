import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] count = new int[2_000 + 1];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            count[x + 1000]++;
        }

        for (int i = -1000; i <= 1_000; i++) {
            if (count[i + 1000] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
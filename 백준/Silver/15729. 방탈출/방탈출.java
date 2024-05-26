import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        boolean[] a = new boolean[n + 2];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) a[i] = true;
            else a[i] = false;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i]) {
                a[i] = !a[i];
                a[i + 1] = !a[i + 1];
                a[i + 2] = !a[i + 2];
                result++;
            }
        }

        System.out.println(result);
    }
}

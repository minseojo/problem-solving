import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = -1;
            for (int i = x; i <= m * n; i += m) {
                if ((i - 1) % n + 1== y) {
                    answer = i;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}

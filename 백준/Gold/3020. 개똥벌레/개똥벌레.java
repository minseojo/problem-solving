import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] up = new int[h + 1];
        int[] down = new int[h + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = h - Integer.parseInt(br.readLine()) + 1;
            up[a]++;
            down[b]++;
        }

        for (int i = 1; i <= h; i++) {
            up[i] += up[i - 1];
        }

        for (int i = h; i >= 1; i--) {
            down[i] += down[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= h; i++) {
            int conflict =  (up[h] - up[i - 1]) + (down[1] - down[i + 1]);

            if (conflict < min) {
                min = conflict;
                count = 1;
            } else if (conflict == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
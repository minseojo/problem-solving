import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int l = 0;
        int r = l + 1;
        while (l < r && r <= n) {
            long sum = ((long) r * (r + 1) / 2) - ((long) l * (l + 1) / 2);
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                l++;
                r = l + 1;
            } else {
                r++;
            }
        }

        System.out.println(answer);
    }
}
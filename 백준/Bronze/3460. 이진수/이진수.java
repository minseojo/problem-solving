import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int k = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    System.out.print(k + " ");
                }
                n /= 2;
                k++;
            }
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String bit = Integer.toString(n, 2);
            for (int j = bit.length() - 1; j >= 0; j--) {
                if (bit.charAt(j) == '1') System.out.print(bit.length() - j - 1 + " ");
            }
        }
    }
}

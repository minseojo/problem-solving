import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s = st.nextToken();
        char cur = ' ';
        int[] count = new int[2];

        for (char c : s.toCharArray()) {
            if (cur == ' ') {
                cur = c;
                continue;
            }

            if (cur != c) {
                if (cur == '0') {
                    count[0]++;
                } else if (cur == '1') {
                    count[1]++;
                }
                cur = c;
            }
        }
        if (cur == '0') {
            count[0]++;
        } else if (cur == '1') {
            count[1]++;
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}

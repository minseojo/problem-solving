import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();

        int sum = 0;
        int[] count = new int[10];
        for (int i = 0; i < n.length(); i++) {
            int x = n.charAt(i) - '0';
            sum += x;
            count[x]++;
        }

        if ((count[0] > 0) && ((sum % 3) == 0)) {
            StringBuilder answer = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < count[i]; j++) {
                    answer.append(i);
                }
            }
            System.out.println(answer.toString());
        } else {
            System.out.println(-1);
        }
    }
}

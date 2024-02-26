import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s = st.nextToken();

        StringBuilder answer = new StringBuilder();
        int sequence = 0;
        for (char c : s.toCharArray()) {
            if (c == 'X') {
                sequence++;
            } else {
                if (sequence == 0) {
                    answer.append('.');
                } else {
                    if (sequence % 2 != 0) {
                        answer = new StringBuilder();
                        answer.append("-1");
                        sequence = 0;
                        break;
                    }

                    for (int i = 0; i < sequence / 4; i++) {
                        answer.append("AAAA");
                    }
                    sequence -= ((sequence / 4) * 4);

                    for (int i = 0; i < sequence / 2; i++) {
                        answer.append("BB");
                    }
                    sequence = 0;
                    answer.append('.');
                }
            }
        }

        if (sequence != 0) {
            if (sequence % 2 != 0) {
                answer = new StringBuilder();
                answer.append("-1");

            } else {
                for (int i = 0; i < sequence / 4; i++) {
                    answer.append("AAAA");
                }
                sequence -= ((sequence / 4) * 4);

                for (int i = 0; i < sequence / 2; i++) {
                    answer.append("BB");
                }
                sequence = 0;
            }
        }
        System.out.println(answer.toString());
    }
}

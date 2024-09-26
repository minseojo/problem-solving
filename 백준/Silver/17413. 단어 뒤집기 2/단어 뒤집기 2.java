import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ' ') {
                if (sb.length() > 0) {
                    answer.append(sb.reverse() + " ");
                }
                sb = new StringBuilder();
                continue;
            }

            if (temp.charAt(i) == '<') {
                if (sb.length() > 0) {
                    answer.append(sb.reverse());
                }
                sb = new StringBuilder();

                int j = i;
                while (j < temp.length() && temp.charAt(j) != '>') {
                    answer.append(temp.charAt(j));
                    j++;
                }
                i = j;
                answer.append(">");
                continue;
            }

            sb.append(temp.charAt(i));
        }

        if (sb.length() > 0) {
            answer.append(sb.reverse());
        }

        System.out.println(answer);
    }
}
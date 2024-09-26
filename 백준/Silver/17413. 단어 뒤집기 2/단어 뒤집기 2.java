import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        for (int j = 0; j < temp.length(); j++) {
            if (!isTag && temp.charAt(j) == ' ') {
                if (!sb.toString().isEmpty()) {
                    answer.append(sb.reverse()).append(" ");
                }
                sb = new StringBuilder();
                continue;
            }
            else if (!isTag && temp.charAt(j) == '<') {
                if (!sb.toString().isEmpty()) {
                    answer.append(sb.reverse());
                    sb = new StringBuilder();
                }
                isTag = true;
            }

            if (temp.charAt(j) == '>') {
                isTag = false;
                answer.append(sb + ">");
                sb = new StringBuilder();
                continue;
            }
            sb.append(temp.charAt(j));
        }
        if (!sb.toString().isEmpty()) {
            answer.append(sb.reverse());
        }

        System.out.println(answer);
    }
}
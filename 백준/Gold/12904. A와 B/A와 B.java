import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());
        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            }
            else {
                t = t.reverse();
                t.deleteCharAt(0);
            }
        }

        System.out.println(s.equals(t.toString()) ? 1 : 0);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(st.nextToken());
        while (tc-- > 0) {
            String s = br.readLine();
            String[] words = s.split(" ");
            for (String word : words) {
                char[] chars = word.toCharArray();
                int len = chars.length;
                for (int i = 0; i < len / 2; i++) {
                    chars[i] = word.charAt(len - i - 1);
                    chars[len - i - 1] = word.charAt(i);
                }
                System.out.print(new String(chars) + " ");
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Data {
        int sum;
        char alpha;
        int value;

        Data(char alpha) {
            this.alpha = alpha;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Data> alpha = new ArrayList<>();
        String[] temp = new String[n];
        for (int i = 0; i < 26; i++) {
            alpha.add(new Data((char) (i + 'A')));
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                alpha.get(s.charAt(j) - 'A').sum += (int) (Math.pow(10, s.length() - j - 1));
            }
            temp[i] = s;
        }

        alpha.sort((a1, a2) -> Integer.compare(a2.sum, a1.sum));

        for (int i = 0; i < 9; i++) {
            alpha.get(i).value = 9 - i;
        }
        alpha.sort((a1, a2) -> Integer.compare(a1.alpha, a2.alpha));

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < temp[i].length(); j++) {
                answer += (alpha.get(temp[i].charAt(j) - 'A').value * (int) Math.pow(10, temp[i].length() - j - 1));
            }
        }
        System.out.println(answer);
    }

}
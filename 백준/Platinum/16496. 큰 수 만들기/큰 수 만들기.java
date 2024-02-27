import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        List<String> numbers = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers.add(st.nextToken());
        }

        Collections.sort(numbers, (String i, String j) -> {
            StringBuilder a = new StringBuilder(i + j);
            StringBuilder b = new StringBuilder(j + i);

            return a.compareTo(b);
        });

        StringBuilder answer = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            answer.append(numbers.get(i));
        }
        
        if (answer.toString().charAt(0) == '0') {
            System.out.println("0");
        } else {
            System.out.println(answer);
        }
    }
}

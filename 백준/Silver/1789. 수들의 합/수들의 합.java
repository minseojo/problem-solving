import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        int answer = 0;
        for (int i = 1; ; i++) {
            if (sum > s) break;
            sum += i;
            answer = i;
        }
        answer -= 1;
        System.out.println(answer);
    }

}
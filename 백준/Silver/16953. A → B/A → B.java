import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (b >= a) {
            if (b % 2 == 0) b /= 2;
            else if (b % 10 == 1) b /= 10;
            else break;
            answer++;
            if (a == b) break;
        }

        if (a != b) answer = -1;
        System.out.println(answer);
    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= i; j++) {
                numbers.add(i);
            }
        }

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += numbers.get(i);
        }

        System.out.println(sum);
    }

}
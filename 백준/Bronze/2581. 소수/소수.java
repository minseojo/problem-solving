import java.util.*;
import java.io.*;

public class Main {

    static int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            for (int j = i + i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
        isPrime[1] = false;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = a; i <= b; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
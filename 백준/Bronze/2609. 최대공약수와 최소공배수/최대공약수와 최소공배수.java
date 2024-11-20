import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int gcd = GCD(n, m);
        int lcm = LCM(n, m, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    static int LCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
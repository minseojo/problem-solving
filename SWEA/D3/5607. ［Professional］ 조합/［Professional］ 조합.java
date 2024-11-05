import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcc; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long nFact = factorial(n) % MOD;
            long rFact = factorial(r) % MOD;
            long nrFact = factorial(n - r) % MOD;

            long answer = nFact * modInverse(rFact * nrFact % MOD) % MOD;

            System.out.println("#" + tc + " " + answer);
        }
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    static long modInverse(long a) {
        return power(a, MOD - 2);
    }

    static long power(long a, int b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}

/**
 * n!
 * r! * (n-r)!
 */
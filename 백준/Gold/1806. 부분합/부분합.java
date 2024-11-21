import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + x;
        }

        int answer = Integer.MAX_VALUE;
        int l = 0;
        int r = l + 1;
        while (r <= n) {
            int sum = prefixSum[r] - prefixSum[l];
            if (sum >= s) {
                answer = Math.min(answer, r - l);
                l++;
            } else {
                r++;
            }
        }

        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }

}
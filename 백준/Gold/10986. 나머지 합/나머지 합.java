import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[n + 1];
        int[] modCount = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + x;
            modCount[(int) (prefixSum[i] % m)]++;
        }

        long answer = modCount[0];
        for (int i = 0; i < m; i++) {
            int x = modCount[i];
            answer += (((long) x * (x - 1)) / 2);
        }

        System.out.println(answer);
    }

}
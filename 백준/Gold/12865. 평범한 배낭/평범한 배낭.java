import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> bag = new ArrayList<>(n);
        
        int[] dp = new int[k + 1]; // 무게에 따른 최대 가치, 배열 크기 = 최대 물품의 수 * 물건 최대 가치

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bag.add(new int[] {w, v});
        }

        for (int[] thing : bag) {
            int w = thing[0];
            int v = thing[1];
//
//            for (int i = w; i <= k; i++) { // 무한 동전 사용가능
//                dp[i] = Math.max(dp[i], dp[i-w] + v);
//            }
/**
 * 5 7
 * 6 13
 * 4 8
 * 3 6
 * 5 12
 * 2 8
 */
            for (int i = k; i >= w; i--) {
                dp[i] = Math.max(dp[i], dp[i-w] + v);
            }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int answer;
    static String n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcc; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = st.nextToken();
            k = Integer.parseInt(st.nextToken());
            if (k > 5) {
                if (k % 2 == 0) k = 4;
                else k = 5;
            }
            int[] cache = new int[k * 2];
            answer = 0;

            dfs(0, cache);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int pos, int[] cache) {
        if (pos == k * 2) {
            char[] chars = n.toCharArray();

            for (int i = 0; i < k; i++) {
                int a = cache[i * 2];
                int b = cache[i * 2 + 1];
                swap(chars, a, b);
            }

            answer=  Math.max(answer, Integer.parseInt(String.valueOf(chars)));

            return;
        }

        for (int i = 0; i < n.length(); i++) {
            if (pos > 0 && cache[pos - 1] == i) continue;
            cache[pos] = i;
            dfs(pos + 1, cache);
        }
    }

    static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
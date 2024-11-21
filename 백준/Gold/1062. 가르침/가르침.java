import java.util.*;
import java.io.*;
import java.util.concurrent.DelayQueue;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
            a[i] = a[i].replace("anta", "");
            a[i] = a[i].replace("tica", "");
        }

        if (k < 5) System.out.println(0);
        else if (k == 26) System.out.println(n);
        else {
            int[] cache = new int[26];
            cache['a' - 'a'] = 1;
            cache['c' - 'a'] = 1;
            cache['n' - 'a'] = 1;
            cache['t' - 'a'] = 1;
            cache['i' - 'a'] = 1;
            k -= 5;

            dfs(0, k, cache, a, 0);
            System.out.println(answer);
        }
    }

    static void dfs(int pos, int k, int[] cache, String[] a, int here) {
        if (pos == k) {
            int count = 0;
            for (String word : a) {
                if (check(word, cache)) count++;
            }

            answer = Math.max(answer, count);
            return;
        }

        for (int i = here; i < 26; i++) {
            if (cache[i] == 0) {
                cache[i] = 1;
                dfs(pos + 1, k, cache, a, i + 1);
                cache[i] = 0;
            }
        }
    }

    static boolean check(String word, int[] cache) {
        for (int i = 0; i < word.length(); i++) {
            if (cache[word.charAt(i) - 'a'] == 0) return false;
        }

        return true;
    }

}
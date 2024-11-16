import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[r], map.getOrDefault(a[r], 0) + 1);
            r++;
        }
        r--;
        
        int i = 0;
        int answer = map.size();
        while (i <= 4 * n) {
            answer = Math.max(answer, map.containsKey(c) ? map.size() : map.size() + 1);
            map.put(a[l], map.getOrDefault(a[l], 1) - 1);
            if (map.get(a[l]) == 0) map.remove(a[l]);
            l = (l + 1) % n;
            r = (r + 1) % n;
            map.put(a[r], map.getOrDefault(a[r], 0) + 1);
            i++;
        }

        System.out.println(answer);
    }
}
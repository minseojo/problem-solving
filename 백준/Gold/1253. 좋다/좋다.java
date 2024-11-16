import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numbers.put(a[i], numbers.getOrDefault(a[i], 0) + 1);
        }

        int answer = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(a[i]) && check(i, a)) {
                visited.add(a[i]);
                answer += numbers.get(a[i]);
            }
        }

        System.out.println(answer);
    }

    static boolean check(int idx, int[] a) {
        int l = 0;
        int r = a.length - 1;
        int target = a[idx];

        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == target && l != idx && r != idx) return true;
            else if (sum > target) r--;
            else l++;
        }

        return false;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] memo = new int[11][11];
        for (int i = 0; i < 10; i++) {
            memo[0][i] = 1;
            memo[1][i] = i;
        }
        for (int i = 2; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += memo[i - 1][k];
                }
                memo[i][j] = sum;
            }
        }

        int maxCount = -1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maxCount += memo[i][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        if (n == maxCount) System.out.println("9876543210");
        else if (n > maxCount) System.out.println("-1");
        else {
            for (int i = 1; i < 10; i++) {
                dfs(0, i, 0, new int[10]);
            }

            numbers.sort((s1, s2) -> {
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                return Integer.compare(s1.length(), s2.length());
            });
            System.out.println(numbers.get(n));
        }
    }

    static void dfs(int pos, int size, int idx, int[] cache) {
        if (pos == size) {
            StringBuilder sum = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sum.insert(0, cache[i]);
            }

            numbers.add(sum.toString());
            return;
        }

        for (int i = idx; i < 10; i++) {
            cache[pos] = i;
            dfs(pos + 1, size, i + 1, cache);
        }
    }
}

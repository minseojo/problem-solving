import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        int size = divisors.size();
        for (int i = 0; i < size; i++) {
            divisors.add(n / divisors.get(i));
        }

        List<Integer> deduplicatedAndSortedDivisors = new ArrayList<>(new TreeSet<>(divisors)); // 중복 제거 및 오름차순

        if (deduplicatedAndSortedDivisors.size() >= k) System.out.println(deduplicatedAndSortedDivisors.get(k - 1));
        else System.out.println(0);
    }
}
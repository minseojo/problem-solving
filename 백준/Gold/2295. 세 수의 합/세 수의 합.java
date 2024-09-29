import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int MAX = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> numbers = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            numbers.add(x);
            list.add(x);
        }

        Collections.sort(list);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = list.get(i) + list.get(j);

                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int totalSum = sum + list.get(mid);

                    if (totalSum <= MAX) {
                        if (numbers.contains(totalSum)) {
                            answer = Math.max(answer, totalSum);
                        }
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}

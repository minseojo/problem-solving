import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            int target = numbers[i];
            int l = 0;
            int r = numbers.length - 1;

            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                
                int sum = numbers[l] + numbers[r];
                if (sum == target) {
                    answer++;
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(answer);
    }
}
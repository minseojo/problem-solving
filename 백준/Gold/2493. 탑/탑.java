import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] tops = new int[n];
        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && tops[stack.peek()] <= tops[i]) {
                answer[stack.pop()] = i + 1;
            }

            stack.push(i);
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
}

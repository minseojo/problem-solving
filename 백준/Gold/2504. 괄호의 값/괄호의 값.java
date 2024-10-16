import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    static int solution(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == ']') return 0;

        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;

        int sum = 1;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(') {
                sum *= 2;
                stack.addLast(c);
            } else if (c == '[') {
                sum *= 3;
                stack.addLast(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return 0;

                if (stack.pollLast() == '(') {
                    if (s.charAt(i - 1) == '(') answer += sum;
                } else return 0;

                sum /= 2;
            } else if (c == ']') {
                if (stack.isEmpty()) return 0;

                if (stack.pollLast() == '[') {
                    if (s.charAt(i - 1) == '[') answer += sum;
                } else return 0;

                sum /= 3;
            }
        }

        if (!stack.isEmpty()) return 0;

        return answer;
    }

}

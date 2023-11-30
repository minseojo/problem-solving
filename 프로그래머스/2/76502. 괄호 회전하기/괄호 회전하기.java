import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            String substring = s.substring(0, i);
            sb.delete(0, i);
            sb.append(substring);
            if (check(sb.toString())) {
                answer++;
            }
        }
        
        return answer;
    }

    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty() && isMatching(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}

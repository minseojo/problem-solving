import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) {
            return 0;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
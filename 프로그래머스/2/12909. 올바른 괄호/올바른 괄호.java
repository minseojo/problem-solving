import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> table = new HashMap<>() {
            {
                put(')', '(');
            }
        };
        
        for (char c : s.toCharArray()) {
            if (!table.containsKey(c)) {
                stack.addLast(c);
            }  else if (stack.isEmpty() || table.get(c) != stack.pollLast()) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
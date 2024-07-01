class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char cur : s.toCharArray()) {
            if (cur == ')' || cur == '}' || cur == ']') {
                if (dq.isEmpty()) return false;
                char prev = dq.peekLast();
                if (prev == '(' && cur != ')') return false;
                else if (prev == '{' && cur != '}') return false;
                else if (prev == '[' && cur != ']') return false;
                dq.pollLast();
            } else {
                dq.addLast(cur);
            }
        }
        
        if (!dq.isEmpty()) return false;

        return true;
    }
}
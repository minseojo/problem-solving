import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursive(p);
        return answer;
    }
    
    private String recursive(String str) {
        if (str.isEmpty()) {
            return str;
        }
        
        int index = findBalncedBracketIndex(str);
        String u = str.substring(0, index);
        String v = str.substring(index, str.length());
        
        
        if (isCorrectBracket(u)) {
            return u + recursive(v);
        } else {
            return "(" + recursive(v) + ")" + makeCorrectString(u);
        }
    }
    
    private int findBalncedBracketIndex(String str) {
        int open = 0;
        int close = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                open++;
            } else {
                close++;
            }
            
            if(open == close) {
                return open + close;
            }
        }

        return 0;
    }
    
    private String makeCorrectString(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i < str.length() - 1; i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stringBuilder.append(')');
            }
            else {
                stringBuilder.append('(');
            }
        }

        return stringBuilder.toString();
    }
    
    private boolean isCorrectBracket(String p) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                s.add('(');
            }
            if (p.charAt(i) == ')') {
                if (!s.isEmpty() && s.peek() == '(') {
                    s.pop();
                } else {
                    s.add(')');
                }
            }
        }
        
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
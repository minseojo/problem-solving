import java.util.*;

class Solution {  
    
    static int[] count = new int[26];
    
    // 오른쪽 쭉
    // 왼쪽 쭉
    // 오른쪽 갔다가 왼쪽
    // 왼쪽 갔다가 오른쪽
    
    public int solution(String name) {
        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (i <= 12) count[i] = i;
            else count[i] = 26 - i;
        }
        
        for (char c : name.toCharArray()) {
            if (c != 'A') {
                answer += count[c - 'A'];
            }
        }
        
        int len = name.length();
        int move = len - 1;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            idx = i + 1;
            while (idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i * 2 + (len - idx));
            move = Math.min(move, (len - idx) * 2 + i);
        }
        answer += move;
        
        return answer;
    }

}
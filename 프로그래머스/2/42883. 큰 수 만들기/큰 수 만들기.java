import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        int pos = 0;
        for (int i = 0; i < k; i++) {
            while (true) {
                if (pos == sb.length() - 1) {
                    sb.delete(pos, pos + 1);
                    break;
                }
                if (sb.charAt(pos) < sb.charAt(pos + 1)) {
                    sb.delete(pos, pos + 1);
                    break;
                }
                pos++;
            }
            if (pos > 0) pos--;
        }
        
        return sb.toString();
    }
}

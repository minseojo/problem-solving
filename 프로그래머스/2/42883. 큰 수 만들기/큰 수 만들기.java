import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (true) {
                if (j == sb.length() - 1) {
                    sb.delete(j, j + 1);
                    break;
                }
                if (sb.charAt(j) < sb.charAt(j + 1)) {
                    sb.delete(j, j + 1);
                    break;
                }
                j++;
            }
            if (j > 0) j--;
        }
        
        return sb.toString();
    }
}

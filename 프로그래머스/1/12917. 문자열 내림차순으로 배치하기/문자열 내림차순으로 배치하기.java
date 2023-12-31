import java.util.*;

class Solution {
    public String solution(String s) {
        int[] a = new int[128];
        for (char c : s.toCharArray()) {
            a[c - 'A']++;    
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 127; i >= 0; i--) {
            if (a[i] > 0) {
                while (a[i]-- > 0) {
                    sb.append((char)(i + 'A'));
                }
            }
        }
        return sb.toString();
    }
}
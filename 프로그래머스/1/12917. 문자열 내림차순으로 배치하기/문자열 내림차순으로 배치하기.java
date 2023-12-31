import java.util.*;

class Solution {
    public String solution(String s) {        
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return new StringBuilder(new String(ca)).reverse().toString();
    }
}
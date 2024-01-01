import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            if (n % 3 == 1 || n % 3 == 2) {
                answer.insert(0, n % 3);
                n /= 3;
            } else if (n % 3 == 0) {
                answer.insert(0, 4);
                n = n / 3 - 1;
            }
        }
        
        return answer.toString();
    }
}
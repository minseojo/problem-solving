import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            String s = "0" + Long.toString(n, 2);
            int index = -1;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '0') {
                    s = s.substring(0, j) + '1' + s.substring(j + 1, s.length());
                    index = j;
                    break;
                }
            }

            for (int j = index + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    s = s.substring(0, j) + '0' + s.substring(j + 1, s.length());
                    break;
                }
            }
            answer[i] = Long.parseLong(s, 2);
        }
        return answer;
    }
}
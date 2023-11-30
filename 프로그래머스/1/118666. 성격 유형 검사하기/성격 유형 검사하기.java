import java.util.*;

class Solution {
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> score = new HashMap<>();
        for (int i = 0; i <survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];
            if (choice == 4) {
                continue;
            }
            if (choice <= 3) {
                score.put(type.charAt(0), score.getOrDefault(type.charAt(0), 0) + 4 - choice); 
            } else {
                score.put(type.charAt(1), score.getOrDefault(type.charAt(1), 0) + choice - 4); 
            }
        }

        int r = score.getOrDefault('R', 0);
        int t = score.getOrDefault('T', 0);
        if (r >= t) {
            answer += "R";
        } else {
            answer += "T";
        }
        int c = score.getOrDefault('C', 0);
        int f = score.getOrDefault('F', 0);
        if (c >= f) {
            answer += "C";
        } else {
            answer += "F";
        }
        int j = score.getOrDefault('J', 0);
        int m = score.getOrDefault('M', 0);
        if (j >= m) {
            answer += "J";
        } else {
            answer += "M";
        }
        int a = score.getOrDefault('A', 0);
        int n = score.getOrDefault('N', 0);
        if (a >= n) {
            answer += "A";
        } else {
            answer += "N";
        }
        return answer;
    }
}
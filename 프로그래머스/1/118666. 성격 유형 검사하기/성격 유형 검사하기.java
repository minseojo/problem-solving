import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = {-1, 3, 2, 1, 0, 1, 2, 3};
        Map<Character, Integer> point = new HashMap<>();
        
        for (char[] t : types) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }
        
        for (int i = 0; i <survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];
            
            if (choice < 4) {
                point.put(type.charAt(0), point.get(type.charAt(0)) + score[choice]); 
            } else {
                point.put(type.charAt(1), point.get(type.charAt(1)) + score[choice]); 
            }
        }
        
        for (char[] t : types) {
            if (point.get(t[0]) >= point.get(t[1])) {
                answer += t[0];
            } else {
                answer += t[1];
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        String preWord = "";
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(words[i]);
            }
        
            if (i != 0 && (preWord.charAt(preWord.length() - 1) != sb.toString().charAt(0) || set.contains(sb.toString()))) {
                return new int[] {i % n + 1, i / n + 1};
            }
            
            set.add(sb.toString());
            preWord = sb.toString();
        }

        return new int[] {0, 0};
    }
}
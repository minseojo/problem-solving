import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> lzw = new HashMap<>();
        int count = 1;
        for (int i = 0; i < 26; i++) {
            lzw.put(Character.toString(((char)(int)'A' + i)), count++);
        }
        
        for (int i = 0; i < msg.length();) {
            String w = "";
            for (int j = msg.length(); j > i; j--) {
                w = msg.substring(i, j);
                Integer x = lzw.get(w);
                if (x != null) {
                    answer.add(x);
                    if (j + 1 < msg.length()) {
                        w = msg.substring(i, j + 1);
                        if (lzw.get(x) == null) {
                            lzw.put(w, count++);
                        }
                    }
                    i = j;
                    break;
                }
            }
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
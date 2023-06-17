import java.util.*;
class Solution {
    static String[] morse = { 
        ".-", "-...", "-.-.",
        "-..", ".", "..-.",
        "--.", "....", "..",
        ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.",
        "--.-", ".-.", "...", "-",
        "..-", "...-", ".--", "-..-",
        "-.--", "--.."
    };
    
    static Map<String, Character> map = new HashMap<>();
    static void init() {
        for (int i = 0; i < 26; i++) {
            map.put(morse[i], (char) ('a'+i));
        }
    }
    public String solution(String letter) {
        init();
        String answer = "";
        String str = "";
        for (char c : letter.toCharArray()) {
            if (c != ' ') {
                str += c;
            } else {
                answer += map.get(str);
                str = "";
            }
        }
        answer += map.get(str);
        return answer;
    }
}
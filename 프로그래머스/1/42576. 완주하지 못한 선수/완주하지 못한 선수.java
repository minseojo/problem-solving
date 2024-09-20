import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        for (String p : participant) {
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            if (participants.getOrDefault(c, 0) > 0) {
                participants.put(c, participants.get(c) - 1);
            }
        }
        
        for (String p : participant) {
            if (participants.getOrDefault(p, 0) > 0) {
                return p;
            }
        }
        
        return "";
    }
}
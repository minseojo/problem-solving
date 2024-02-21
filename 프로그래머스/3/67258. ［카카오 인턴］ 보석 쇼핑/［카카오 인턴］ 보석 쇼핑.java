import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        int[] answer = new int[] {0, gems.length - 1}; // start, end
        Set<String> excepted = new HashSet<>();
        for (String g : gems) {
            excepted.add(g);
        }
        
        Map<String, Integer> gemMap = new HashMap<>();
        int l = 0;
        for (int r = 0; r < gems.length; r++) {
            gemMap.put(gems[r], gemMap.getOrDefault(gems[r], 0) + 1);
            
            while (gemMap.size() == excepted.size() && l < r) {
                int count = gemMap.get(gems[l]);
                if (count - 1 > 0) {
                    gemMap.put(gems[l], count - 1);
                    l++;
                } else {
                    break;
                }
            }
                
            if (gemMap.size() == excepted.size() && r - l < answer[1] - answer[0]) {
                answer[0] = l;
                answer[1] = r; 
            }
        }
        
        answer[0] += 1;
        answer[1] += 1;
        return answer;
    }
}
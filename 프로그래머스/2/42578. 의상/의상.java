import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i : map.values()) {
            list.add(i);
        }
        
        int answer = 1;
        for (int i = 0; i < list.size(); i++) {
            answer *= (list.get(i) + 1);
        }
        
        return answer - 1;
    }
}
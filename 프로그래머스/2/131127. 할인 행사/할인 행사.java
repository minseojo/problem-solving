import java.util.*;

class Solution {
    static final int DISCOUNT_DAY = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        Map<String, Integer> actual = new HashMap<>();
        int l = 0;
        int r = DISCOUNT_DAY - 1;
        
        for (int i = 0; i < DISCOUNT_DAY; i++) {
            actual.put(discount[i], actual.getOrDefault(discount[i], 0) + 1);
        }
        if (check(wants, actual)) {
            answer++;
        }

        while (r < discount.length - 1) {
            String deleteMenu = discount[l++];
            String addMenu = discount[++r];
            actual.put(deleteMenu, actual.getOrDefault(deleteMenu, 0) - 1);
            actual.put(addMenu, actual.getOrDefault(addMenu, 0) + 1);
            if (check(wants, actual)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean check(Map<String, Integer> wants, Map<String, Integer> actual) {
        for (Map.Entry<String, Integer> entry : wants.entrySet()) {

            if (!entry.getValue().equals(actual.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}
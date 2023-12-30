import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        a.put(topping[0], 0);
        for (int i = 1; i < topping.length; i++) {
            b.put(topping[i], i);
        }
        if (a.size() == b.size()) {
            answer++;
        }
        for (int i = 1; i < topping.length; i++) {
            a.put(topping[i], i);
            if (b.get(topping[i]) == i) {
                b.remove(topping[i]);
            }
            if (a.size() == b.size()) {
                answer++;
            }
        }
        return answer;
    }
}
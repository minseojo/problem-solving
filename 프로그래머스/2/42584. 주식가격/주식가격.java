import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            int price = prices[i];
            int time = 0;
            for (int j = i + 1; j < size; j++) {
                time++;
                if (price > prices[j]) {
                    break;
                }
            }
            list.add(time);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
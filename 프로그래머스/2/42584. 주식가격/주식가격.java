// 시간 복잡도 : O(n)
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}

/* 시간 복잡도: O(n^2)
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
*/
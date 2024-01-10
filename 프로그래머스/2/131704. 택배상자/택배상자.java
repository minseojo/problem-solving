import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> firstContainer = new Stack<>();
        Stack<Integer> secondContainer = new Stack<>();
        
        int firstOrder = order[0];
        for (int i = order.length; i >= 1; i--) {
            firstContainer.add(i);
            if (firstOrder == i) {
                for (int j = 1; j < i; j++) {
                    secondContainer.add(j);
                }
                break;
            }
        }
        
        int orderCount = 0;
        while (orderCount < order.length) {
            int orderItem = order[orderCount++];
            if (!firstContainer.isEmpty() && firstContainer.peek().intValue() == orderItem) {
                firstContainer.pop();
                answer++;
            } else if (!secondContainer.isEmpty() && secondContainer.peek().intValue() == orderItem) {
                secondContainer.pop();
                answer++;
            } else { 
                while (!firstContainer.isEmpty() && orderItem != firstContainer.peek()) {
                    secondContainer.add(firstContainer.pop());
                }
                if (!firstContainer.isEmpty() && firstContainer.peek() == orderItem) {
                    answer++;
                    firstContainer.pop();
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}
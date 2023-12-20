import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            } else {
                answer[i] = -1;
            }
            stack.add(numbers[i]);
        }
        
        return answer;
    }
}
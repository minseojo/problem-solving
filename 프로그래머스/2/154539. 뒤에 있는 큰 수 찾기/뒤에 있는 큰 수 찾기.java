import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                answer.add(stack.peek());
            } else {
                answer.add(-1);
            }
            stack.add(numbers[i]);
        }
        
        Collections.reverse(answer);
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}
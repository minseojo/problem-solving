import java.util.*;

class Solution {
    
    class Data {
        int value;
        int index;
        
        Data (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Data> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            
            if (stack.isEmpty()) {
                stack.addLast(new Data(p, i));
                continue;
            }
            
            while (!stack.isEmpty() && stack.peekLast().value > p) {
                Data d = stack.pollLast();
                answer[d.index] = i - d.index;
            } 
            stack.addLast(new Data(p, i));
        }
        
        while (!stack.isEmpty()) {
            Data d = stack.pollLast();
            answer[d.index] = prices.length - d.index - 1;
        }
        answer[prices.length - 1] = 0;
        return answer;
    }
}
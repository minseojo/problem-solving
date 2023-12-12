import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] parts = operation.split(" "); 
            String op = parts[0];
            int value = Integer.valueOf(parts[1]);
            
            if (op.equals("I")) {
                maxPQ.add(value);
            } else if (op.equals("D")) {
                if (value == 1) {
                    if (!maxPQ.isEmpty()) {
                        maxPQ.poll();
                    }
                } else if (value == -1) {
                    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
                    minPQ.addAll(maxPQ);
                    minPQ.poll();
                    maxPQ.clear();
                    maxPQ.addAll(minPQ);
                }
            }
        }
        
        if (maxPQ.isEmpty()) {
            return new int[] {0, 0};
        }
        
        int[] answer = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        while (!maxPQ.isEmpty()) {
            int top = maxPQ.poll();
            answer[0] = Math.max(answer[0], top);
            answer[1] = Math.min(answer[1], top);
        }
        return answer;
    }
}
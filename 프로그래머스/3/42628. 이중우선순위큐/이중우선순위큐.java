import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation: operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) {
                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));
            } else {
                if (op[1].equals("1")) {
                    minHeap.remove(maxHeap.poll());
                } else if (op[1].equals("-1")) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        return new int[]{maxHeap.isEmpty() ? 0 : maxHeap.peek(), 
                         minHeap.isEmpty() ? 0 : minHeap.peek()};
    }
}
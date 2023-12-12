import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            sum1 += i;
            q1.add(i);
        }
        
        for (int i : queue2) {
            sum2 += i;
            q2.add(i);
        }
        
        int answer = 0, size = (q1.size() + q2.size()) * 3;
        while (size-- > 0) {
            if (sum1 == sum2) {
                return answer;
            }
            
            if (sum1 > sum2) {
                int front = q1.poll();
                sum1 -= front;
                sum2 += front;
                q2.add(front);
            } else if (sum1 < sum2) {
                int front = q2.poll();
                sum1 += front;
                sum2 -= front;
                q1.add(front);
            }
            answer++;
        }
        
        
        return -1;
    }
}
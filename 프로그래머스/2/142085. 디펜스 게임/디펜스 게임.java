import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int kCount = 0;
        for (int e : enemy) {
            pq.add(e);
            sum += e;
            while (sum > n) {
                if (!pq.isEmpty() && kCount < k) {
                    sum -= pq.poll();
                    kCount++;
                } else break;
            }
            
            if (sum > n) break;
            answer++;
        }

        return answer;
    }
}
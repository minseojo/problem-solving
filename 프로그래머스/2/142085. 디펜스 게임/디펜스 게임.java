import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int round = enemy.length;
        int l = 0, r = round;
        
        while (l <= r) {
            int m = (l + r) / 2;
            long sum = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0 ; i < m; i++) {
                pq.add(enemy[i]);
                if (pq.size() > k) {
                   sum += pq.poll();     
                }
            }
           
            if (sum > n) {
                r = m - 1;
            } else {
                answer = Math.max(answer, m);
                l = m + 1;
            }
        }
        return answer;
    }
}
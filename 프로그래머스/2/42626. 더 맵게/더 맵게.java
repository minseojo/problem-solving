import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        
        if (pq.peek() < K) return -1;
        return answer;
    }
}
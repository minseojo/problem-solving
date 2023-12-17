import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        while (!pq.isEmpty() && pq.peek() < K) {
            if (!pq.isEmpty()) {
                int first = pq.poll();
                if (!pq.isEmpty()) {
                    int second = pq.poll();
                    pq.add(first + second * 2);
                } else {
                    return -1;
                }
            }
            answer++;
        }
        return answer;
    }
}
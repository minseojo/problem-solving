import java.util.*;

class Solution {
    static int MAX = 1_000_000;
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[MAX + 1];
        
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int front = q.poll();
                if (front == y) {
                    return answer;
                }
                if (front * 2 <= MAX && !visited[front * 2]) {
                    visited[front * 2] = true;
                    q.add(front * 2);
                }
                if (front * 3 <= MAX && !visited[front * 3]) {
                    visited[front * 3] = true;
                    q.add(front * 3);
                }
                if (front + n <= MAX && !visited[front + n]) {
                    visited[front + n] = true;
                    q.add(front + n);
                }
            }
            answer++;
        }
        
        return -1;
    }
}
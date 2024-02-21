import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> sequence = new ArrayList<>();
        
        long cycle = 1;
        for (int i = 1; i <= n; i++) {
            sequence.add(i);
            cycle *= i;
        }
        
        k--; // 배열 인덱스는 0부터, k는 1부터 시작 하므로 -> k -=1
        for (int i = 0; i < n; i++) {
            cycle /= (n - i);
            answer[i] = sequence.remove((int) (k / cycle));
            k %= cycle;
        }
        return answer;
    }
}
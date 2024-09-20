import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cloth = new int[n + 1];
        Arrays.fill(cloth, 1);

        for (int l : lost) cloth[l]--;
        for (int r : reserve) cloth[r]++;
        
        for (int i = 1; i <= n; i++) {
            if (cloth[i] == 0) {
                if (i - 1 >= 1 && cloth[i - 1] > 1) {
                    if (cloth[i - 1] > 1) {
                        cloth[i - 1]--;
                        answer++;
                    }
                } else if (i + 1 <= n && cloth[i + 1] > 1) {
                    cloth[i + 1]--;
                    answer++;
                }
            } else if (cloth[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
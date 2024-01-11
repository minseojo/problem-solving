import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = idx; j < B.length; j++) {
                if (A[i] < B[j]) {
                    answer++;
                    idx = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
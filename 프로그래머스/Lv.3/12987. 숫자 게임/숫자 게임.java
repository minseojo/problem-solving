import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> b = new ArrayList<>();
        for (int i : B) {
            b.add(i);
        }
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < b.size(); j++) {
                if (A[i] < b.get(j)) {
                    answer++;
                    b.remove(j);
                    break;
                }
            }
        }

        return answer;
    }
}
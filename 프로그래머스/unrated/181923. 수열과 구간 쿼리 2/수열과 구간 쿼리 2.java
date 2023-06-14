import java.util.*;

class Solution {
    private final static int LIMIT = 987654321;
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int pos = 0;

        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            answer[pos] = LIMIT;
            for (int i = s; i <= e; i++) {
                int num = arr[i];
                if(num > k) {
                    answer[pos] = Math.min(answer[pos], num);
                }
            }
            if(answer[pos] == LIMIT) answer[pos] = -1;
            pos++;
        }
        return answer;
    }
}
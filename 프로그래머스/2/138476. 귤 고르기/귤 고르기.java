import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        int[] count = new int[10_000_001];
        for (int i : tangerine) {
            count[i]++;
        }
        
        Arrays.sort(count);
        int sum = 0;
        int answer = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            
            sum += count[i];
            answer++;
            if (sum >= k) {
                break; 
            }
        }
        return answer;
    }
}
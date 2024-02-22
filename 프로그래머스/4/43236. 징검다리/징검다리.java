import java.util.*;

class Solution {

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int l = 0, r = distance;

        while (l <= r) {
            int m = (l + r) / 2;
            int pos = 0;
            int removeCount = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - pos < m) {
                    removeCount++;
                } else {
                    pos = rocks[i];
                }
            }
            if (distance - pos < m) {
                removeCount++;
            }
            
            if (removeCount > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return l - 1;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        
        while (l <= r) {
            int sum = people[l] + people[r];
            if (sum <= limit) {
                l++;
                r--;
                answer++;
            } else {
                answer++;
                r--;
            }
        }

        return answer;
    }
}
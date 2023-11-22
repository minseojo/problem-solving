import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        if (arr.length <= 1) {
            return answer;
        }
        
        int pre = -1;
        for (int sequence = 0; sequence < arr.length; sequence++) {
            int cur = arr[sequence];
            if (cur != pre) {
                answer.add(cur);
            }
            pre = arr[sequence];
        }

        return answer;
    }
}
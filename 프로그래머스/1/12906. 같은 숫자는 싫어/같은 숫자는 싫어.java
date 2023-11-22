import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        for (int sequence = 0; sequence < arr.length; sequence++) {
            int cur = arr[sequence];
            if (cur != pre) {
                list.add(cur);
            }
            pre = arr[sequence];
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
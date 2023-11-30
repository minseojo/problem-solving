import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : elements) {
            list.add(i);
        }
        for (int i : elements) {
            list.add(i);
        }
        
        for (int i = 1; i <= list.size() / 2; i++) {
            for (int j = 0; j < list.size(); j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += list.get((j + k) % list.size());
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
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

        for (int len = 1; len <= list.size() / 2; len++) {
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                for (int j = i; j < len + i; j++) {
                    sum += list.get(j % list.size());
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}

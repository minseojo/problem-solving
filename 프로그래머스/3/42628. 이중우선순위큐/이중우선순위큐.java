import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        for (String operation : operations) {
            String[] op = operation.split(" ");
            if (op[0].equals("I")) {
                int num = Integer.parseInt(op[1]);
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
            } else {
                if (count == 0) continue;
                if (op[1].equals("1")) {
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else if (op[1].equals("-1")) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
                count--;
            }
        }

        if (count == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}

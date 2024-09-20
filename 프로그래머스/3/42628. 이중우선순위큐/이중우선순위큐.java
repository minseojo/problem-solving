import java.util.*;

class Solution {
    public int[] solution(String[] operations) {        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            char command = op.charAt(0);
            int value = Integer.valueOf(op.substring(2));
            
            if (command == 'I') {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            
            if (command == 'D') {
                if (map.size() == 0) continue;
                
                int key = -1;
                if (value == 1) {
                    key = map.lastKey();
                    map.put(key, map.get(key) - 1);
                } else {
                    key = map.firstKey();
                    map.put(key, map.get(key) - 1);
                }
                
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
        }
        
        if (map.size() == 0) {
            return new int[] {0, 0};
        }
        
        return new int[] {map.lastKey(), map.firstKey()};
    }
}
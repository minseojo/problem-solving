import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i+=2) {
            result.add(i);
        }
        
        return result
            .stream()
            .mapToInt(i->i)
            .toArray();
    }
}
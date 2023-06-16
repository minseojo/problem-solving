import java.util.*;

class Solution {
    private static List<Integer> list = new ArrayList<>();
    static boolean[] check = new boolean[555555551];
    
    private static void generator(String str, int r) {
        int val = Integer.parseInt(str);
        if(check[val] || val > r) return;
        
        list.add(val);
        check[val] = true;
        generator(str+"0", r);
        generator(str+"5", r);
    }
    
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        generator("5", r);
        for(int x : list) {
            if(l <= x && x <= r) {
                result.add(x);
            }
        }
        
        Collections.sort(result);
        
        if(result.isEmpty()) result.add(-1);
        return result
            .stream()
            .mapToInt(i->i)
            .toArray();
    }
}
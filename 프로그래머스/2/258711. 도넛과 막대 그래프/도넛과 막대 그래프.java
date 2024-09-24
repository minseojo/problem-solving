import java.util.*;

class Solution {
    
    static int IN = 0;
    static int OUT = 1;
    
    int[] answer = new int[4];
    int max;
    Map<Integer, int[]> map = new HashMap<>(); // [key, (in, out)]
    
    public int[] solution(int[][] edges) {
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            map.putIfAbsent(u, new int[2]);
            map.get(u)[OUT]++;
            map.putIfAbsent(v, new int[2]);
            map.get(v)[IN]++;
            
            max = Math.max(max, Math.max(u, v));
        }
        
        for (int i = 1; i <= max; i++) {
            if (map.get(i) == null) continue;
            int in = map.get(i)[IN];
            int out = map.get(i)[OUT];

            if (out == 0) {
                answer[2]++;   
            } else if (out >= 2 && in == 0) {
                answer[0] = i;
            } else if (out == 2) {
                if (in > 0) answer[3]++;
            } 
        }
        
        answer[1] = map.get(answer[0])[OUT] - answer[2] - answer[3];
        return answer;
    }
}
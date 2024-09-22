import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<String, Integer> route = new HashMap<>();
        
        for (int[] r : routes) {
            int time = 0;
            int sr = points[r[0] - 1][0];
            int sc = points[r[0] - 1][1];

            String key = time + "," + sr + ","+ sc;

            route.put(key, route.getOrDefault(key, 0) + 1);

            for (int i = 1; i < r.length; i++) {
                int er = points[r[i] - 1][0];
                int ec = points[r[i] - 1][1];
 
                while (sr != er) {
                    if (sr < er) {
                        sr++;
                    } else {
                        sr--;
                    }
                    ++time;
                    key = time + "," + sr + ","+ sc;
                    route.put(key, route.getOrDefault(key, 0) + 1);
                }

                while (sc != ec) {
                    if (sc < ec) {
                        sc++;
                    } else {
                        sc--;
                    }
                    ++time;
                    key = time + "," + sr + ","+ sc;
                    route.put(key, route.getOrDefault(key, 0) + 1);
                }
            }
        }
        
        for (int count : route.values()) {
            if (count > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
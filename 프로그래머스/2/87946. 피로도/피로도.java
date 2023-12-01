import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int[] cache = new int[dungeons.length];
        backtracking(0, dungeons, visited, cache, k);
        return answer;
    }
    
    private void backtracking(int pos, int[][] dungeons, boolean[] visited, int[] cache, int k) {
        if (pos == dungeons.length) {
            int fatigue = k;
            int result = 0;
            for (int i = 0; i < cache.length; i++) {
                int index = cache[i];
                if (fatigue >= dungeons[index][0]) {
                    result++;
                    fatigue -= dungeons[index][1];
                }
            }

            answer = Math.max(answer, result);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cache[pos] = i;
            backtracking(pos + 1, dungeons, visited, cache, k);
            visited[i] = false;
        }
    }
}
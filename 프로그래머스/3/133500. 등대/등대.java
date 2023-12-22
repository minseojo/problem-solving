import java.util.*;

class Solution {
    static int OFF = 0;
    static int ON = 1;
    int answer = 0;
    
    public int solution(int n, int[][] lighthouse) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
    
        for (int[] i : lighthouse) {
            int a = i[0];
            int b = i[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] light = new int[n + 1];
        dfs(1, -1, list, light);
        return answer;
    }
    
    private void dfs(int here, int parent, List<List<Integer>> list, int[] light) {
        for (int i = 0; i < list.get(here).size(); i++) {
            int next = list.get(here).get(i);
            if (next == parent) {
                continue;
            }
            dfs(next, here, list, light);
            if (light[here] == OFF && light[next] == OFF) {
                light[here] = ON;
                answer++;
            }
        }
    }
}
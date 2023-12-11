import java.util.*;

class Solution {
    static int INF = 10000000;
    Set<Integer> answer = new HashSet<>();
    boolean[] isPrime = new boolean [INF];
    
    public int solution(String numbers) {
        setupPrime();
        dfs(numbers, new boolean[8], 0, "");
        return answer.size();
    }
    
    private void dfs(String numbers, boolean[] visited, int pos, String cur) {
        if (!cur.isBlank()) {
            int value = Integer.parseInt(cur);
            System.out.println(value);
            if (isPrime[value]) {
                System.out.println(value + " true" );
                answer.add(value);
            }
        }
            
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, visited, pos + 1, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private void setupPrime() {
        for (int i = 2; i < INF; i++) isPrime[i] = true;
        for (int i = 2; i < Math.sqrt(INF); i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < INF; j += i) {
                    isPrime[j] = false;
                }    
            }
        }
    }
}
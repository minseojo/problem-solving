class Solution {
    static int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] cache = new int[n + 1][m + 1];
        cache[1][2] = 1;
        cache[2][1] = 1;
        for (int[] p : puddles) {
            cache[p[1]][p[0]] = -1; // 웅덩이
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cache[i][j] == -1) {
                    continue;
                }
                if (cache[i - 1][j] > 0) {
                    cache[i][j] += (cache[i - 1][j] % MOD);
                }
                if (cache[i][j - 1] > 0) {
                    cache[i][j] += (cache[i][j - 1] % MOD);   
                }
            }
        }
        
        return cache[n][m] % MOD;
    }
}

/*
import java.util.*;
class Solution {
    static int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] cache = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cache[i], -1);
        }
        for (int[] p : puddles) {
            cache[p[1]][p[0]] = -2; // 웅덩이
        }
        findRoute(1, 1, cache, n, m, puddles);

        return cache[1][1];
    }
    
    private int findRoute(int y, int x, int[][] cache, int n, int m, int[][] puddles) {
        if (y == n && x == m) {
            return 1;
        }

        if (y < 1 || x < 1 || y > n || x > m || cache[y][x] == -2) {
            return 0;
        } else if (cache[y][x] != -2 && cache[y][x] != -1) {
            return cache[y][x];
        }
        
        return cache[y][x] = findRoute(y + 1, x, cache, n, m, puddles) % MOD + 
                            findRoute(y, x + 1, cache, n, m, puddles) % MOD;
    }
}
*/
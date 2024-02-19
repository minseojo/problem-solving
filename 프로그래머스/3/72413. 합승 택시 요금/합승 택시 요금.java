class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i ++) {
            for (int j = 0 ; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = 1_000_000;
            }
        }
        for (int[] f : fares) {
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        
        // s, a, b, c
        // s -> c
        // c -> a
        // c -> b
        int[] sToC = new int[n + 1];
        for (int c = 1; c <= n; c++) { // 합승 후 하차 지점
            if (s == c) continue;
            sToC[c] = dist[s][c];
        }
        
        for (int c = 1; c <= n; c++) { // C
            answer = Math.min(answer, sToC[c] + dist[c][b] + dist[c][a]);
        }

        return answer;
    }
}
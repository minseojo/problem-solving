
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n + 1][n + 1];
        int INF = 200000000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        
        for (int i = 0; i < fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int cost = fares[i][2];
            dist[u][v] = Math.min(dist[u][v], cost);
            dist[v][u] = Math.min(dist[v][u], cost);
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        
        return answer;
    }
}
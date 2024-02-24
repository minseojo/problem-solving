import java.util.*;

class Solution {

    int INF = 1_000_000;
    
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxDp[i][j] = -INF;
                minDp[i][j] = INF;
            }
        }
        
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = Integer.parseInt(arr[i * 2]);
            minDp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int step = 1; step < n; step++) {
            for (int i = 0; i < n - step; i++) {
                int j = i + step;
                
                for (int k = i; k < j; k++) {
                    if (arr[k * 2 + 1].equals("+")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k+1][j]);
                    } else if (arr[k * 2 + 1].equals("-")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k+1][j]);
                    }
                }
            }
        }
        
        return maxDp[0][n-1];
    }
}
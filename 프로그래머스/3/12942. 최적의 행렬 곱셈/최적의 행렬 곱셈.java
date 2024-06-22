class Solution {
    
    private int[][] matrix;
    private int[][] dp;
    
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        matrix = matrix_sizes;
        dp = new int[n][n];

        return matmul(0, n - 1);
    }
    
    private int getMatmulDP(int l, int r) {
        if (dp[l][r] == 0) {
            dp[l][r] = matmul(l, r);
        }
        return dp[l][r];
    }
    
    private int matmul(int l, int r) {
        if (r - l == 0) {
            return dp[l][r] = 0;
        }
    
        if (r - l == 1) {
            return dp[l][r] = matrix[l][0] * matrix[l][1] * matrix[r][1];
        }
        
        int result = Integer.MAX_VALUE;
        for (int m = l; m < r; m++) {
            int leftMatmul = getMatmulDP(l, m);
            int rightMatmul = getMatmulDP(m + 1, r);
            int midMatmul = matrix[l][0] * matrix[m][1] * matrix[r][1];
            result = Math.min(result, leftMatmul + rightMatmul + midMatmul);
        }
        return result;
    }
}


/*
class Solution {
    
    private int[][] matrix;
    private int[][] dp;
    
    static int INF = 987654321;
    
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        this.matrix = matrix_sizes;
        this.dp = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = INF;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int l = j;
                int r = j + i;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + matrix[l][0] * matrix[k][1] * matrix[r][1]);
                }
            }
        }        
        
        return dp[0][n - 1];
    }
}

// 행렬이 2개일 때는 연산 횟수가 일정 하지만, 행렬의 개수가 3개 이상일 때는 연산의 순서에 따라서 곱하기 연산의 횟수가 바뀔 수 있습니다.
*/
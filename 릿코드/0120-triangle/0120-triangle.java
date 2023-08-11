class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        
        int[][] dp = new int[222][222];
        dp[0][0] = triangle.get(0).get(0);

        int result = 123456;
        for(int i=1; i<triangle.size(); i++) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                if(j==0) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                else if(j==triangle.get(i).size()-1) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                else dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                System.out.print(dp[i][j] + " ");
            }
        }

        for(int i=0; i<triangle.get(triangle.size()-1).size(); i++) {
            result = Math.min(result, dp[triangle.size()-1][i]);
        }
        
        return result;
    }
}
class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int i = 0, j =0;
        while (i < (num_list.length / n) && j < n) {
            answer[i][j] = num_list[i * n + j];
            j++;
            if (j == n) {
                i++;
                j = 0;
            }
        }
        return answer;
    }
}
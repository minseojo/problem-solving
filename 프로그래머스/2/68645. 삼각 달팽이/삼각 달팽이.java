class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n+1)) / 2];
        int[][] tri = new int[n][n];
        int cnt = 1;
        int dir = 0; // 하 우 왼대각(0 1 2)
        int y = -1;
        int x = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dir == 0) {
                    tri[++y][x] = cnt++;    
                } else if (dir == 1) {
                    tri[y][++x] = cnt++;
                } else if (dir == 2) {
                    tri[--y][--x] = cnt++;
                }
            }
            dir = (dir + 1) % 3;
        }
        
        int ansCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[ansCnt++] = tri[i][j];
            }
        }
        return answer;
    }
}
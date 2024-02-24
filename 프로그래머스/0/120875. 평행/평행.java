class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        if ((double)(dots[0][0] - dots[1][0]) / (dots[0][1] - dots[1][1])
            == (double)(dots[2][0] - dots[3][0]) / (dots[2][1] - dots[3][1])) answer = 1;
        if ((double)(dots[0][0] - dots[2][0]) / (dots[0][1] - dots[2][1])
            == (double)(dots[1][0] - dots[3][0]) / (dots[1][1] - dots[3][1])) answer = 1;
        if ((double)(dots[0][0] - dots[3][0]) / (dots[0][1] - dots[3][1])
            == (double)(dots[1][0] - dots[2][0]) / (dots[1][1] - dots[2][1])) answer = 1;
        // 1 2, 3 4
        // 1 3, 2 4
        // 1 4, 2 3
        return answer;
    }
}
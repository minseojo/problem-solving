class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int clash = 0;
        for (int i = -100; i <= 100; i++) {
            clash = 0;
            if(lines[0][0] <= i && i < lines[0][1]) clash++;
            if(lines[1][0] <= i && i < lines[1][1]) clash++;
            if(lines[2][0] <= i && i < lines[2][1]) clash++;
            
            if(clash > 1) answer++;
        }
        return answer;
    }
}
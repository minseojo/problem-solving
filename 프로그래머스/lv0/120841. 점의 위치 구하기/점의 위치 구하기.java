class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int y = dot[0];
        int x = dot[1];
        if (y > 0 && x > 0) answer = 1;
        else if (y < 0 && x > 0) answer = 2;
        else if (y < 0 && x < 0) answer = 3;
        else answer = 4;
        return answer;
    }
}
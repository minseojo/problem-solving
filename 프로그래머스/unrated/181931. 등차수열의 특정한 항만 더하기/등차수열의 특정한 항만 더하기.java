class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int value = a;
        for(boolean check : included) {
            if(check) {
                answer += value;
            }
            value += d;
        }
        return answer;
    }
}
class Solution {
    public long solution(int w, int h) {
        double fx = (double)-h/w;
        
        long answer = 0;
        for(int i = 1; i < w; i++){
            answer += (int)((double)fx * i + h) * 2;
        }
        return answer;
    }
}
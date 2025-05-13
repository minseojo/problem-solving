class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int numCol = (num - 1) % w;
        int floor = 2 * w;
        
        int box = n - num;
        int intervalQ = box / floor;
        int intervalR = box % floor;
        
        int threshold = 2 * (w - 1 - numCol) + 1;
        
        answer = 1 + 2 * intervalQ + (intervalR >= threshold ? 1 : 0);
        return answer;
    }
}
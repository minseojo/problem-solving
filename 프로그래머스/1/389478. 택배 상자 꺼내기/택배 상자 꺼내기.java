class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (num - 1) / w;
        int col;
        
        if (row % 2 == 0) {
            col = (num - 1) % w; // 왼 -> 오
        } else {
            col = w - (num - 1) % w - 1;   // 오 -> 왼
        }
        
        for (int r = row + 1; ; r++) {
            int base = r * w;
            if (base >= n) break;
            
            int boxNumber;
            if (r % 2 == 0) {
                boxNumber = base + col + 1;
            } else {
                boxNumber = base + w - col;
            }
            
            if (boxNumber <= n) {
                answer++;
            }
        }
        
        return answer + 1;
    }
}
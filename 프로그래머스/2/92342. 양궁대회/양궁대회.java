class Solution {
    
    int[] lion;
    int[] apach;
    int[] answer;
    int N;
    int maxDiff;
    
    public int[] solution(int n, int[] info) {
        apach = info;
        lion = new int[11];
        N = n;
        answer = new int[11];
        dfs(0, 0);
        return maxDiff == 0 ? new int[] {-1} : answer;
    }
        
    void dfs(int pos, int cnt) {
        if (pos == 11 || cnt == N) {
            int lionSum = 0;
            int apachSum = 0;
            if (pos == 11 && cnt < N) lion[10] = N - cnt; 
            for (int i = 0; i < 11; i++) {
                if (lion[i] == apach[i] && lion[i] == 0) continue;
                if (apach[i] < lion[i]) {
                    lionSum += (10 - i);
                } else {
                    apachSum += (10 - i);
                }
            }
            
            int diff = lionSum - apachSum;
            if (diff > 0 && (diff > maxDiff || (diff == maxDiff && isBetterAnswer()))) {
                maxDiff = diff;
                System.arraycopy(lion, 0, answer, 0, 11);  // 배열 복사
            }
            
            return;
        }
        
        for (int i = 0; i <= N - cnt; i++) {
            lion[pos] = i;
            dfs(pos + 1, cnt + i);
            lion[pos] = 0;
        }
    }
    
    boolean isBetterAnswer() {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > answer[i]) return true; // 더 낮은 점수를 더 많이 맞힌 경우
            else if (lion[i] < answer[i]) return false; // answer가 더 낮은 점수를 많이 맞힌 경우
        }
        return false; // 동일한 경우
    }
}
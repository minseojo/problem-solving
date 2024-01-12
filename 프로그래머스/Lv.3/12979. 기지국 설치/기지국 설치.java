class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int pos = 0;
        for (int s : stations) {
            int dist = (s - w) - pos - 1;
            pos = s + w;
            if (dist <= 0) {
                continue;
            }
            if (dist / (2 * w + 1) == 0 ) {
                answer++;
            } else {
                answer += (dist / (2 * w +1));
                if (dist % (2 * w + 1) != 0) {
                    answer++;
                }
            }
        }

        if (pos < n) {
            int dist = n - pos;
            answer += dist / (2 * w + 1);
            if (dist > 0 && dist / (2 * w + 1) == 0) {
                answer++;
            } else if (dist % (2 * w + 1) != 0) {
                answer++;
            }
        }
        return answer;
    }
}
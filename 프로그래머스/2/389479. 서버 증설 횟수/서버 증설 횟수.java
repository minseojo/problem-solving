// 그리디
// 1. 이전 까지의 사람 + 현재 사람 > m 큰 경우 서버 키기.
// 2. (1)반복

// 살아 있는 서버의 마지막 시간 + 접속 인원


class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int hour = 24;
        int[] remainServer = new int[hour];
        
        for (int i = 0; i < hour; i++) {
            int player = players[i];

            if (player >= m) {
                int remain = remainServer[i] * m;
                if (remain < player) {
                    answer += ((player - remain) / m);
                    for (int j = i; j < i + k; j++) {
                        if (j >= hour) break;
                        remainServer[j] += ((player - remain) / m);
                    }   
                }
            }
        }
        
        return answer;
    }
}
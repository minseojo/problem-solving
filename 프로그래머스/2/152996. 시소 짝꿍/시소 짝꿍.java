import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] weightCount = new int [1001];
        for (int i : weights) {
            weightCount[i]++;
        }
        //1 1 1 1 1 1
         // 1 3 6 10 15
        for (int i = 100; i<= 1000; i++) {
            if (weightCount[i] > 1) {
                answer += ((long) weightCount[i] * (weightCount[i] - 1)) / 2;
                System.out.println(i + " " + answer);
            }
            if (weightCount[i] == 0) continue;
            for (int j = i + 1; j <= 1000; j++) {
                if (weightCount[j] == 0) continue;
                boolean ok = false;
                for (int k = 2; k <= 4; k++) {
                    for (int l = 2; l <= 4; l++) {
                        if (k * i == j * l) ok = true;
                        if (ok) break;
                    }
                    if (ok) {
                        answer += ((long) weightCount[i] * weightCount[j]);
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
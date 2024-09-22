class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int len = diffs.length;
        int l = 1, r = 1000000000;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            long sum = 0;
            for (int stage = 0; stage < len; stage++) {
                if (diffs[stage] <= m) {
                    sum += times[stage];
                } else {
                    if (stage > 0) {
                        sum += ((diffs[stage] - m) * (times[stage] + times[stage - 1]) + times[stage]);
                    } else {
                        sum += ((diffs[stage] - m) * (times[stage]) + times[stage]);
                    }
                }
            }

            if (sum <= limit) {
                r = m - 1;
                answer = m;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }
}

// diff <= level : += time_cur
// diff > leve.  : += (diff - level) * (time_cur + time_prev)
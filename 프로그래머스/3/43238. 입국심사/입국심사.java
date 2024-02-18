class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long l = 1, r = -1;
        for (int t : times) {
            r = Math.max(r, t);
        }
        r *= n;
        while (l <= r) {
            long m = (l + r) / 2;
            long sum = 0;
            for (long t : times) {
                sum += (m / t);
            }

            if (sum >= n) {
                answer = Math.min(answer, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }
}
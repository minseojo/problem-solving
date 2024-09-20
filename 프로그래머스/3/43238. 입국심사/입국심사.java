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
            long x = 0;
            for (int t : times) {
                x += (m / t);
            }
            
            if (x >= n) {
                answer = Math.min(answer, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        if (n < cores.length) {
            return n;
        }

        int remainJob = n - cores.length;
        int totalTime = findTotalTime(remainJob, cores);

        int[] a = new int[cores.length];
        for (int i = 0; i < cores.length; i++) {
            int x = (totalTime - 1) / cores[i];
            remainJob -= x;
            a[i] = (totalTime / cores[i]) - x;
        }
        
        for (int i = 0; i < a.length; i++) {
            remainJob -= a[i];
            if (remainJob <= 0) {
                return i + 1;
            }
        }
        
        return 0;
    }
    
    private int findTotalTime(int remainJob, int[] cores) {
        int l = 1;
        int r = 100000000;
        int result = 100000000;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = 0;
            for (int c : cores) {
                sum += (m / c);
            }
            
            if (sum >= remainJob) {
                r = m - 1;
                result = Math.min(result, m);
            } else {
                l = m + 1;
            }
        }
        
        return result;
    }
}
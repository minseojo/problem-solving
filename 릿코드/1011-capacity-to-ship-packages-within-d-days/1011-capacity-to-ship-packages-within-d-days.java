class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int result = Integer.MAX_VALUE;
        int l=0, r=0, m=0;
        for(int i=0; i<weights.length; i++) r += weights[i];


        while(l<=r) {
            // m은 1 days당 최대 무게
            m = l + (r-l)/2;
            int x = isPossible(weights, days, m);
            if(x != Integer.MAX_VALUE) {
                result = Math.min(result, x);
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return result;
    }
    public int isPossible(int[] weights, int days, int m) {
        int max = 0;
        int sum = 0;
        int compDays = 1;

        for(int i=0; i<weights.length; i++) {
            max = Math.max(max, sum);
            if(sum + weights[i] <= m) {
                sum += weights[i];
            } else {
                compDays++;
                sum = weights[i];
            }
        }
        max = Math.max(max, sum);
        System.out.println(m + " " + compDays + " " + max);
        if(compDays <= days) return max;
        else return Integer.MAX_VALUE;
    }
}
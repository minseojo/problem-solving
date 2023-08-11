class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);

        long l=Long.MAX_VALUE, r=0;
        long min=Long.MAX_VALUE;
        for(int i : time){
            l = Math.min(l, i);
            min = Math.min(min, i);
        }
        r=totalTrips*min;

        long result=r;
        while(l<=r) {
            long m =(l+r)/2;
            long sum=0;
            for(int i=0; i<time.length; i++) {
                sum += (m/time[i]);
            }

            if(totalTrips <= sum) {          
                result = Math.min(result, m);
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return result;
    }
}
/**
100
2
[10000]
10000000
 */
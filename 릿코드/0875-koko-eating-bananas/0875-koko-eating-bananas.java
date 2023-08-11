class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=0;
        for(int pile : piles) {
            r = Math.max(r, pile);
        }
        
        int result = r;
        while(l<=r) {
            int m = l + (r-l)/2;
            long pileSum = 0;
            for(int pile : piles) {
                if(pile%m == 0) {pileSum += pile/m;}
                else {pileSum += ((pile/m) + 1);}
            }

            if(pileSum <= h) {
                result = Math.min(result, m);
                r = m-1;
            } else {
                l=m+1;
            }
        }
        
        return result;
    }
}
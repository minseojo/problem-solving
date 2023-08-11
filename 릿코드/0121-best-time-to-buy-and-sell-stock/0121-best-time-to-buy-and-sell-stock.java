class Solution {
    
    public int maxProfit(int[] prices) {
        int min = 10001;
        int result = 0;
        
        for(int i=0; i<prices.length; i++) {
            if(min > prices[i]) min = prices[i];
            
            if(result < prices[i]-min) result = prices[i]-min;
        }
        
        return result;
    }

}
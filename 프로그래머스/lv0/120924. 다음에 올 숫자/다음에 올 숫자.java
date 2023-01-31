class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int[] sum = new int[common.length];
        int[] product = new int[common.length];
        for(int i=0; i<common.length-1; i++) {
            int cur = common[i];
            int next = common[i+1];
            sum[i] = next-cur;
            if(cur == 0) {
                product[i] = 0;
            }
            else product[i] = next/cur; 
        }
        
        boolean sumFlag = true;
        boolean productFlag = true;

        for(int i=0; i<common.length-2; i++) {
            if(sum[i] != sum[i+1]) sumFlag = false;
            if(product[i] != product[i+1]) productFlag = false;
        }

        if(sumFlag) answer = common[common.length-1] + (sum[0]);
        else if(productFlag) answer = common[common.length-1] * (product[0]);
        
        return answer;
    }
}
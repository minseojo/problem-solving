class Solution {
    public int reverse(int x) {
        long answer = 0;
        int temp = 0;
        while(x!=0) {
            temp = x%10;
            answer = answer * 10 + temp;
            x/=10;
        }
        if(answer >= Integer.MAX_VALUE-1 || answer <= Integer.MIN_VALUE) return 0;
        return (int)answer;
    }
} 

//  1534236469
//  
// 
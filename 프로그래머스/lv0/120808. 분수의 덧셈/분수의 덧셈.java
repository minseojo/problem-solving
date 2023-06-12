class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        int gcdVal = gcd(numer, denom);
        numer /= gcdVal;
        denom /= gcdVal;
        
        int[] answer = new int[2];
        answer[0] = numer;
        answer[1] = denom;
        return answer;
    }
}
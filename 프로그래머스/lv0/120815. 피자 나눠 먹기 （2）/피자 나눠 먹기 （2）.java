class Solution {
    private static final int SLICE = 6;
    
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    public int solution(int n) {
        int x = gcd(n, SLICE); // 최대 공약수
        return n / x;
    }
}
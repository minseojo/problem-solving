class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = gcd(n, m);
        int lcm = lcm(n, m, gcd);
        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    
    private int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
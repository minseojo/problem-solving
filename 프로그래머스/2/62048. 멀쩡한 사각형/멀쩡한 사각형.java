class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public long solution(int w, int h) {
        int gcd = gcd(w, h);
        return ((long) h * w) - (((h / gcd) + (w / gcd) - 1) * gcd);
    }
}
/*
class Solution {
    public long solution(int w, int h) {
        double fx = (double)-h/w;
        
        long answer = 0;
        for(int i = 1; i < w; i++){
            answer += (int)((double)fx * i + h) * 2;
        }
        return answer;
    }
}
*/
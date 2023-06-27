import java.math.*;
class Solution {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        int[] LCM = new int[arr.length];
        LCM[0] = arr[0];
        // 2
        for (int i = 1; i < arr.length; i++) {
            int g = gcd(arr[i], LCM[i-1]);
            LCM[i] = (LCM[i-1] * arr[i]) / g;
            answer = Math.max(answer, LCM[i]);
            
        }
        return answer;
    }
}
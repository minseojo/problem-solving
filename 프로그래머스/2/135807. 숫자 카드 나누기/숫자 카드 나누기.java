class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = 0;
        int aGcd = findGcd(arrayA);
        int bGcd = findGcd(arrayB);
        
        a = solve(arrayA, bGcd);
        a = Math.max(a, solve(arrayB, aGcd));
        return a;
    }
    
    int solve(int[] array, int gcd) {
        for (int i : array) {
            if (i % gcd == 0) return 0;
        }
        return gcd;
    }
    
    int findGcd(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = GCD(result, array[i]);
        }
        return result;
    }
    
    int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
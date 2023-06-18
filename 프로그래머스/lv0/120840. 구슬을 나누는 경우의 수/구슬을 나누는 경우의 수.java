import java.math.BigInteger;
class Solution {
    
    static BigInteger fact(int n) {
        BigInteger bi = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            BigInteger x = BigInteger.valueOf(i);
            bi = bi.multiply(x);
        }
        return bi;
    }
    
    public BigInteger solution(int balls, int share) {
        BigInteger a = fact(balls);
        BigInteger b = fact(balls-share);
        BigInteger c = fact(share);
        return a.divide(b).divide(c);
    }
}
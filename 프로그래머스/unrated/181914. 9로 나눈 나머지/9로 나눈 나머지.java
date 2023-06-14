import java.math.*;
class Solution {
    public int solution(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            sum += (int) (c - '0');
        }
        return sum % 9;
    }
}
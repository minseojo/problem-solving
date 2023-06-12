class Solution {
    public int solution(double num1, double num2) {
        double result = Math.floor((double) (num1 / num2) * 1000);
        return (int) Math.floor(result);
    }
}
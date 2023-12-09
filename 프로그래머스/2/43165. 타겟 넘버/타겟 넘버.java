import java.util.*;

class Solution {
    char[] sign = {'+', '-'};
    int answer = 0;
    public int solution(int[] numbers, int target) {
        char[] expression = new char[numbers.length];
        backtracking(0, numbers, target, expression);
        return answer;
    }
    
    private void backtracking(int pos, int[] numbers, int target, char[] expression) {
        if (pos == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (expression[i] == '+') {
                    sum += numbers[i];
                } else if (expression[i] == '-') {
                    sum -= numbers[i];
                }
            }
            
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < sign.length; i++) {
            expression[pos] = sign[i];
            backtracking(pos + 1, numbers, target, expression);
        }
    }
}
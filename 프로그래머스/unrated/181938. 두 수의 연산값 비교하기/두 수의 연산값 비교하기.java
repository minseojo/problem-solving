class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String strSum1 = strA + strB;
        answer = Math.max(Integer.valueOf(strSum1), 2*a*b);
        return answer;
    }
}
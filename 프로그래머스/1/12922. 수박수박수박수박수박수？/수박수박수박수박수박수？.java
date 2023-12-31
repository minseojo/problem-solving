class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int pos = 0;
        while (n-- > 0) {
            if (pos % 2 == 0) {
                answer.append("수");
            } else {
                answer.append("박");
            }
            pos++;
        }
        return answer.toString();
    }
}
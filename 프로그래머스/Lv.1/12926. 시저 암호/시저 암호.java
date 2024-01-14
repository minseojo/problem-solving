class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(" ");
            } else if (c <= 'z' && c >= 'a') {
                int index = ((c - 'a') + n) % 26;   
                answer.append((char)(index + 'a'));
            } else if (c <= 'Z' && c >= 'A') {
                int index = ((c - 'A') + n) % 26;
                answer.append((char)(index + 'A'));
            }
        }
        
        return answer.toString();
    }
}
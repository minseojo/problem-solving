class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int pos = my_string.length()-n;
        while(n > 0) {
            answer += my_string.charAt(pos++);
            n--;
        }
        return answer;
    }
}
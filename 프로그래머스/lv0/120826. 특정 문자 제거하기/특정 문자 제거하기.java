
class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder answer = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (c != letter.charAt(0)) {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}

class Solution {
    public String solution(int age) {
        // a = 97
        String answer = "";
        String str_age = String.valueOf(age);
        for (char c : str_age.toCharArray()) {
            answer += (char) ((int) (c-'0') + 97);
        }
        return answer;
    }
}
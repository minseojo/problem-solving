class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = false; // 1 = true, 0 = false
        int pos = 0;
        for (char c : code.toCharArray()) {
            if (!mode) {
                if (c == '1') mode = true;
                else if(c != '1' && pos % 2 == 0) answer += c;
            }
            else if (mode) {
                if (c == '1') mode = false;
                else if (c != '1' && pos % 2 == 1) answer += c;
            }
            pos++;
        }
        if(answer.equals("")) return "EMPTY";
        else return answer;
    }
}
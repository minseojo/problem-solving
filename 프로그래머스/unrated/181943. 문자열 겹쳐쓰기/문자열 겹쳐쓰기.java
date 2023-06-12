class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String before = my_string.substring(0, s);
        String after = my_string.substring(s + overwrite_string.length());
        return before + overwrite_string + after;
    }
}
/*class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int pos = 0;
        int overwrite_pos = 0;
        while(true) {
            if(pos > my_string.length()) break;
            
            if(pos < s) answer += my_string.charAt(pos);
            else if(pos >= s) {
                if(overwrite_pos >= overwrite_string.length()) {
                    for(int i=pos; i<my_string.length(); i++) {
                        answer += my_string.charAt(i);
                    }
                    break;
                }
                answer += overwrite_string.charAt(overwrite_pos);
                overwrite_pos++;
            } 
            pos++;
        }

        return answer;
    }
}*/
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int pos = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                pos = 0;
                sb.append(" ");
            } else {
                if (pos % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                pos++;
            }
        }
        
        return sb.toString();
    }
}
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String upper = s.toUpperCase();
        String lower = s.toLowerCase();
        int pos = 0;
        int wordIndex = 0;
        while (pos < s.length()) {
            if (s.charAt(pos) == ' ') {
                wordIndex = 0;
                sb.append(" ");
            } else {
                if (wordIndex % 2 == 0) {
                    sb.append(upper.charAt(pos));
                } else {
                    sb.append(lower.charAt(pos));
                }
                wordIndex++;
            }
            pos++;
        }
        return sb.toString();
    }
}
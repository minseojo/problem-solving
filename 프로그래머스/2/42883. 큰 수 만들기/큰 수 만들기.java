class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(number);
        int pos = 0;
        int deletedNumberCount = 0;
        while (pos < sb.length() && deletedNumberCount < k) {
            if (pos + 1 < sb.length() && 
                sb.charAt(pos) - '0' < sb.charAt(pos + 1) - '0') {
                sb.deleteCharAt(pos);
                deletedNumberCount++;
                if (pos != 0) {
                    pos--;
                }   
            } else {
                pos++;
            }
            
        }
        
        for (int i = deletedNumberCount; i < k; i++) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString(); 
    }
}
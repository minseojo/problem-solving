class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            b = b.replace("aya", "1");
            b = b.replace("ye", "2");
            b = b.replace("woo", "3");
            b = b.replace("ma", "4");
            
            boolean ok = true;
            for (int i = 0; i < b.length(); i++) {
                if (!('1' <= b.charAt(i) && b.charAt(i) <= '4')) {
                    ok = false;
                    break;
                }
                
                if (i < b.length() - 1 && b.charAt(i) == b.charAt(i+1)) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
            
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            answer += Integer.valueOf(s.charAt(i) - '0') * Math.pow(3, s.length() - i - 1);
        }
        return answer;
    }
}
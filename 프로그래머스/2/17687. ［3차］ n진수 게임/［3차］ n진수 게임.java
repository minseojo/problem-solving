class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; pattern.length() < t * m; i++) {
            pattern.append(Integer.toString(i, n));
        }
        
        String x = pattern.toString();
        for (int i = p-1; i < pattern.length() && answer.length() < t; i+=m) {
            char c = x.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = Character.toUpperCase(c);
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}
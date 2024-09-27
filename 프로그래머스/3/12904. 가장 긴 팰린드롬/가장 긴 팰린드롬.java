class Solution {
    public int solution(String s) {
        if (s.length() == 0) return 0;

        int answer = 1;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            int l = i - 1;
            int r = i + 1;
            int sum = 1;
            while (l >= 0 && r < len) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (lc == rc) {
                    sum += 2;
                } else break;
                l--;
                r++;
            }
            answer = Math.max(answer, sum);
            
            l = i - 1;
            r = i;
            sum = 0;
            while (l >= 0 && r < len) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (lc == rc) {
                    sum += 2;
                } else break;
                l--;
                r++;
            }
            answer = Math.max(answer, sum);
            
        }
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String pre = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j <= s.length(); j += i) {
                int endIndex = Math.min(j + i, s.length());
                String cur = s.substring(j, endIndex);
                if (cur.equals(pre)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(pre);
                    cnt = 1;
                }
                pre = cur;
            }
            sb.append(pre);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.valueOf(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (i + p.length() > t.length()) {
                continue;
            }
            long tValue = Long.valueOf(t.substring(i, i + p.length()));
            if (tValue <= pValue) {
                answer++;
            }
            System.out.println(tValue);
        }
        return answer;
    }
}
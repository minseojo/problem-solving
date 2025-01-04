class Solution {
    public int maxScore(String s) {
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            int cnt = 0;
            String left = s.substring(0, i);
            String right = s.substring(i);
            for (int j = 0; j < left.length(); j++) if (left.charAt(j) == '0') cnt++;
            for (int j = 0; j < right.length(); j++) if (right.charAt(j) == '1') cnt++;
            
            result = Math.max(result, cnt);
        }

        return result;
    }
}
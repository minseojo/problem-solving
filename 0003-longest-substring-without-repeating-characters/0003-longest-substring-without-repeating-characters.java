class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> counter = new HashMap<>();
        int l = 0;
        int r = 0;

        for (char c : s.toCharArray()) {
            if (counter.containsKey(c) && l <= counter.get(c)) {
                l = counter.get(c) + 1;
            } else {
                answer = Math.max(answer, r - l + 1 );
            }
            counter.put(c, r);
            r++;
        }

        return answer;
    }
}
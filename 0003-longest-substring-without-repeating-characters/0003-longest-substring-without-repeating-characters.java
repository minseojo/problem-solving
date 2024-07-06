class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        int answer = 0;
        Map<Character, Integer> counter = new HashMap<>();

        int l = 0;
        int r = 1;
        counter.put(s.charAt(l), 1);
        while (r < s.length()) {
            if (counter.getOrDefault(s.charAt(r), 0) == 0) {
                counter.put(s.charAt(r), 1);
            } else {
                counter.put(s.charAt(r), counter.get(s.charAt(r)) + 1);
                char c = s.charAt(r);
                while (counter.get(c) > 1) {
                    counter.put(s.charAt(l), counter.get(s.charAt(l)) - 1);
                    if (counter.get(s.charAt(l)) == 0) counter.remove(s.charAt(l));
                    l++;
                }
            }
            r++;
            answer = Math.max(answer, counter.size());
        }

        return answer;
    }
}
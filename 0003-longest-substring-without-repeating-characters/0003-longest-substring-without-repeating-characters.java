class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        int l = 0;
        int r = 1;
        int result = r - l;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), 1);
        while (l < r && r < s.length()) {
            while (map.get(s.charAt(r)) != null && map.get(s.charAt(r)) > 0) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
            map.put(s.charAt(r), map.getOrDefault(r, 0) + 1);
            r++;
        }

        return result;
    }
}
// abba
//  (lr)
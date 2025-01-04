class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        Map<Character, List<Integer>> index = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) index.put(c, new ArrayList<>());
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index.get(c).add(i);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (index.get(c).size() > 1) {
                boolean[] visited = new boolean[26];
                int start = index.get(c).get(0);
                int end = index.get(c).get(index.get(c).size() - 1);

                for (int mid = start + 1; mid < end; mid++) {
                    char visit = s.charAt(mid);
                    if (!visited[visit - 'a']) {
                        visited[visit - 'a'] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
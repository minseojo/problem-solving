class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] count = findMaxWordCount(words2);
        
        for (String word : words1) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }

            if (isSubset(count, wordCount)) result.add(word);
        }

        return result;
    }

    int[] findMaxWordCount(String[] words) {
        int[] count = new int[26];
        
        for (String word: words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }

        return count;
    }

    boolean isSubset(int[] base, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (base[i] > wordCount[i]) return false;
        }

        return true;
    }
}
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordLen = words.length;
        int queryLen = queries.length;
        int[] prefixSum = new int[wordLen];
        int[] result = new int[queryLen];

        int sum = 0;
        for (int i = 0; i < wordLen; i++) {
            String word = words[i];
            if (isVowelByFirstAndLastWord(word)) sum++;
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queryLen; i++) {
            int[] query = queries[i];
            if (query[0] == 0) result[i] = prefixSum[query[1]];
            else result[i] = prefixSum[query[1]] - prefixSum[query[0] - 1];
        }
        
        return result;
    }

    public boolean isVowelByFirstAndLastWord(String word) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
    }
}
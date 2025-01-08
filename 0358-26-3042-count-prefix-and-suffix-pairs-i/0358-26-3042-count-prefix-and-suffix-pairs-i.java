class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) result++;
            }
        }

        return result;
    }

    boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
            if (str1.charAt(str1.length() - i - 1) != str2.charAt(str2.length() - i - 1)) return false;
        }

        return true;
    }
}
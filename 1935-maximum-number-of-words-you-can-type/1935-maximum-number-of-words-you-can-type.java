class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int answer = 0;

        boolean[] isBrokenChar = new boolean[26];
        for (char brokenChar : brokenLetters.toCharArray()) {
            isBrokenChar[brokenChar - 'a'] = true;
        }

        var splitTexts = text.split(" ");
        for (String splitText : splitTexts) {
            boolean isAvailable = true;
            for (char charByText : splitText.toCharArray()) {
                var charIdx = charByText - 'a';
                if (isBrokenChar[charIdx]) {
                    isAvailable = false;
                    break;
                }
            }
            
            if (isAvailable) answer++;
        }

        return answer;
    }
}
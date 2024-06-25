class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 전처리
        paragraph = paragraph.replaceAll("[^\\w]+", " ").toLowerCase();
        String[] words = paragraph.split(" ");

        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            if (!ban.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
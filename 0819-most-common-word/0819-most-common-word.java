class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 전처리
        paragraph = paragraph.replaceAll("\\W+", " ").toLowerCase();
        String[] words = paragraph.split(" ");

        Set<String> ban = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();

        for (String word : banned) {
            ban.add(word);
        }

        for (String word : words) {
            if (!ban.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
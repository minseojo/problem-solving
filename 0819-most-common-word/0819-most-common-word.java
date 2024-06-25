class Solution {
public String mostCommonWord(String paragraph, String[] banned) {
        // 전처리
        paragraph = paragraph.replaceAll("\\W+", " ").toLowerCase();
        String[] words = paragraph.split(" ");

        Set<String> ban = new HashSet<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : banned) {
            ban.add(word);
        }

        for (String word : words) {
            if (!ban.contains(word)) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> ketSet = new ArrayList<>(countMap.keySet());
        ketSet.sort((i, j) -> {
            return countMap.get(j).compareTo(countMap.get(i));
        });
        
        return ketSet.get(0);
    }
}
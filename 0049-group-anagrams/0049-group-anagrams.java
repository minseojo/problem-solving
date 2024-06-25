class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedStr = str.chars()
                    .sorted()
                    .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint, 
                        StringBuilder::append)
                    .toString();

            List<String> strList = map.getOrDefault(sortedStr, new ArrayList<>());
            strList.add(str);
            map.put(sortedStr, strList);
        }

        for (String key : map.keySet()) {
            List<String> strList = map.get(key);
            result.add(new ArrayList<>(strList));
        }

        return result;
    }
}
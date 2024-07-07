class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) return Collections.emptyList();
        
        List<String> answer = new ArrayList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        dfs(0, new StringBuilder(), digits, map, answer);

        return answer;
    }

    void dfs(int pos, StringBuilder comb, String digits, Map<Character, List<Character>> map, List<String> answer) {
        if (comb.toString().length() == digits.length()) {
            answer.add(comb.toString());
            return;
        }

        for (int i = 0; i < map.get(digits.charAt(pos)).size(); i++) {
            comb.append(map.get(digits.charAt(pos)).get(i));
            dfs(pos + 1, comb, digits, map, answer);
            comb.deleteCharAt(pos);
        }
    }
}
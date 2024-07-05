class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Set<Character> jewelSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) answer++;
        }

        return answer;
    }
}
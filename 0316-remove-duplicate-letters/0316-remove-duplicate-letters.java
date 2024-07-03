class Solution {

    public String removeDuplicateLetters(String s) {
        for (char c : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(c));
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
            }
        }

        return "";
    }

    public Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>((i , j) -> {
            return Integer.compare(i.charValue(), j.charValue());
        });

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
            set.add(words[i].length());
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = words[i].length();

            if (len == 1) {
                if (map.containsKey("")) {
                    result.add(Arrays.asList(i, map.get("")));
                    result.add(Arrays.asList(map.get(""), i));
                }
                continue;
            }

            String rev = new StringBuilder(words[i]).reverse().toString();

            if (map.containsKey(rev) && map.get(rev) != i) {
                result.add(Arrays.asList(i, map.get(rev)));
            }

            for (Integer k : set) {
                if (k == len) break;

                if (isPalindrome(rev, 0, len - k - 1)) {
                    String s1 = rev.substring(len - k);
                    if (map.containsKey(s1)) {
                        result.add(Arrays.asList(i, map.get(s1)));
                    }
                }

                if (isPalindrome(rev, k, len - 1)) {
                    String s2 = rev.substring(0, k);
                    if (map.containsKey(s2)) {
                        result.add(Arrays.asList(map.get(s2), i));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

// class TrieNode {

//     TrieNode[] children = new TrieNode[26];
//     int wordId;

//     TrieNode(int wordId) {
//         this.wordId = wordId;
//     }
// }

// class Trie {

//     TrieNode root = new TrieNode(-1);
     
//     public void insert(String word, int index) {
//         TrieNode node = root;
//         for (int i = word.length() - 1; i >= 0; i--) {
//             char c = word.charAt(i);
//             if (node.children[c - 'a'] == null) {
//                 node.children[c - 'a'] = new TrieNode(-1);
//             }
//             node = node.children[c - 'a'];
//         }
//         node.wordId = index;
//     }
    
//     public int search(String word, int index) {
//         TrieNode node = root;
//         for (char c : word.toCharArray()) {
//             if (node.children[c - 'a'] == null) return -1;
//             node = node.children[c - 'a'];
//         }
//         System.out.println(word + " " + node.wordId);
//         if (node.wordId != -1 && node.wordId != index) {
//             return node.wordId;
//         }
//         return -1;
//     }

// }

// class Solution {
//     public List<List<Integer>> palindromePairs(String[] words) {
//         Trie trie = new Trie();
//         List<List<Integer>> result = new ArrayList<>();
        
//         for (int i = 0; i < words.length; i++) {
//             String word = words[i];
//             trie.insert(word, i);
//         }

//         for (int i = 0; i < words.length; i++) {
//             String word = words[i];
//             int wordId = trie.search(word, i);
//             if (wordId != -1) {
//                 result.add(List.of(i, wordId));
//             }
//         }

//         return result;
//     }
// }


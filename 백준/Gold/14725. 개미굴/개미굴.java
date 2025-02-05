import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    static final String LINE = "--";

    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();

        void insert(String fullWord) {
            TrieNode cur = this;
            String[] words = fullWord.split(" ");
            for (String word : words) {
                cur.children.putIfAbsent(word, new TrieNode());
                cur = cur.children.get(word);
            }
        }

        void print(int depth, StringBuilder result) {
            TrieNode cur = this;
            if (cur.children.isEmpty()) return;

            for (String child : children.keySet()) {
                result.append(LINE.repeat(depth)).append(child).append("\n");
                cur.children.get(child).print(depth + 1, result);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);

            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < k + 1; j++) {
                sb.append(input[j]).append(" ");
            }
            root.insert(sb.toString());
        }

        root.print(0, result);
        System.out.println(result.toString());
        br.close();
    }
}

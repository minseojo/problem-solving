import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Trie {
        Trie[] number;
        boolean finished;

        Trie() {
            this.number = new Trie[10];
            this.finished = false;
        }

        boolean insert(int pos, String s) {
            if (pos == s.length()) {
                this.finished = true;
                return true; // 삽입 성공
            }

            int posNumber = s.charAt(pos) - '0';

            if (this.finished) {
                return false; // 현재 번호가 이미 다른 번호의 접두사 인 경우, 삽입 도중 NO 리턴
            }

            if (number[posNumber] == null) {
                number[posNumber] = new Trie();
            }
            return number[posNumber].insert(pos + 1, s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<String> phoneNumbers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                phoneNumbers.add(br.readLine());
            }

            phoneNumbers.sort(String::compareTo);
            
            Trie trie = new Trie();
            boolean hasPrefix = false;
            for (String phoneNumber : phoneNumbers) {
                if (!trie.insert(0, phoneNumber)) {
                    hasPrefix = true;
                    break;
                }
            }

            result.append(hasPrefix ? "NO" : "YES").append("\n");
        }

        System.out.println(result.toString());

        br.close();
    }
}

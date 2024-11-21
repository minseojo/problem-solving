import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        List<Integer> matches = KMP(text, pattern);

        System.out.println(matches.size());
        for (Integer match : matches) {
            System.out.println(match + 1);
        }
    }

    public static List<Integer> KMP(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        int[] lps = makeTable(pattern);

        int i = 0; // text의 인덱스
        int j = 0; // pattern의 인덱스

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // 부분 일치 테이블 생성
    private static int[] makeTable(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // 현재 접두사와 접미사가 일치하는 길이
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                lps[i] = ++length;
                i++;
            } else {
                if (length == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    length = lps[length - 1]; // 중요!
                }
            }
        }

        return lps;
    }

}
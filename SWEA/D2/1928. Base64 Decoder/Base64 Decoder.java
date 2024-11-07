import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static char[] base64Chars = new char[64];
    static Map<Character, Integer> base64 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        initTable();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcc = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= tcc; tc++) {
            String s = br.readLine();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < s.length(); i += 4) {
                int x1 = base64.get(s.charAt(i));
                int x2 = base64.get(s.charAt(i + 1));
                int x3 = base64.get(s.charAt(i + 2));
                int x4 = base64.get(s.charAt(i + 3));
                String temp = convert(x1) + convert(x2) + convert(x3) + convert(x4);
                int a = Integer.parseInt(temp.substring(0, 8), 2);
                int b = Integer.parseInt(temp.substring(8, 16), 2);
                int c = Integer.parseInt(temp.substring(16, 24), 2);

                answer.append((char) (a));
                answer.append((char) (b));
                answer.append((char) (c));
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static String convert(int c) {
        return String.format("%06d", Integer.parseInt(Integer.toBinaryString(c)));
    }

    static void initTable() {
        for (int i = 0; i < 26; i++) base64Chars[i] = (char) ('A' + i);
        for (int i = 26; i < 52; i++) base64Chars[i] = (char) ('a' + i - 26);
        for (int i = 52; i < 62; i++) base64Chars[i] = (char) ('0' + i - 52);
        base64Chars[62] = '+';
        base64Chars[63] = '/';

        for (int i = 0; i < 64; i++) {
            base64.put(base64Chars[i], i);
        }
    }
/**
 * 1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
 * 2. 각 숫자들을 6자리 이진수로 표현하고, 이 이진수들을 한 줄로 쭉 이어 붙인다.
 * 3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 십진수로 바꾼다.
 * 4. 각각의 십진수를 아스키 코드로 변환한다.
 */
}
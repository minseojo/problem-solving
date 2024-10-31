import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        int curLen = s.length();
        int maxLen = curLen % 2 == 0 ? curLen * 2 : curLen * 2 - 1;
        int result = 0;

        for (int len = 0; len <= maxLen - curLen; len++) {
            if (isPalindrome(s)) {
                result = s.length();
                break;
            }
            s.append('?');
        }

        System.out.println(result);
    }

    static boolean isPalindrome(StringBuilder s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '?' || s.charAt(s.length() - i - 1) == '?') continue;
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
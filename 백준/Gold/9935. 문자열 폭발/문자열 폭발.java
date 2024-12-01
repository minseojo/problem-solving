import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        StringBuilder stack = new StringBuilder();
        for (char c : s1.toCharArray()) {
            stack.append(c);

            if (stack.length() >= s2.length() && isMatch(stack, s2)) {
                stack.setLength(stack.length() - s2.length());
            }
        }
        
        System.out.println(stack.toString().isBlank() ? "FRULA" : stack.toString());
    }

    static boolean isMatch(StringBuilder stack, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            if (stack.charAt(stack.length() - s2.length() + i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

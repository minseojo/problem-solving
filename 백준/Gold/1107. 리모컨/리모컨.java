import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int MAX = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] lock = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < m; i++) {
                int lockBtn = Integer.parseInt(st.nextToken());
                lock[lockBtn] = true;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i < MAX * 2; i++) {
            String buttons = String.valueOf(i);
            if (isOpenAllLock(buttons, lock)) {
                result = Math.min(result, Math.abs(n - i) + buttons.length());
            }
        }
        System.out.println(result);
    }

    private static boolean isOpenAllLock(String buttons, boolean[] lock) {
        for (char c : buttons.toCharArray()) {
            if (lock[c - '0']) {
                return false;
            }
        }
        return true;
    }
}

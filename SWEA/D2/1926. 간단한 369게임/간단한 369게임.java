import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (char c : String.valueOf(i).toCharArray()) {
                int x = c - '0';
                if (x != 0 && x % 3 == 0) count++;
            }
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    System.out.print('-');
                }
                System.out.print(" ");
            }
            else System.out.print(i + " ");
        }
    }
}

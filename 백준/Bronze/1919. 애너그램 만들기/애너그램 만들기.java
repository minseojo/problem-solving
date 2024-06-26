import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[] aCount = new int[26];
        int[] bCount = new int[26];

        for (char c : a) {
            aCount[c - 'a']++;
        }
        for (char c : b) {
            bCount[c - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(aCount[i] - bCount[i]);
        }
        System.out.println(result);
    }
}

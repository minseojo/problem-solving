import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String temp = br.readLine();
        int[] dna = new int[s];
        // ACGT
        for (int i = 0; i < s; i++) {
            char c = temp.charAt(i);
            if (c == 'A') dna[i] = 0;
            else if (c == 'C') dna[i] = 1;
            else if (c == 'G') dna[i] = 2;
            else if (c == 'T') dna[i] = 3;
        }

        // ACGT
        int[] minDna = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minDna[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[4];
        int answer = 0;
        int start = 0;
        int end = 1;

        result[dna[start]]++;
        while (end - start < p - 1) {
            result[dna[end]]++;
            end++;
        }
        if (end < s) result[dna[end]]++;

        if (p == s) {
            if (satisfiedDnaMinCount(minDna, result)) answer++;
        } else {
            while (end < s) {
                if (satisfiedDnaMinCount(minDna, result)) answer++;
                result[dna[start]]--;
                start++;
                end++;
                if (end < s) {
                    result[dna[end]]++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean satisfiedDnaMinCount(int[] minDna, int[] result) {
        for (int i = 0; i < 4; i++) {
            if (result[i] < minDna[i]) {
                return false;
            }
        }

        return true;
    }
}

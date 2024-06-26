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

        for (int i = 0; i < p; i++) {
            result[dna[i]]++;
        }

        for (int i = 0; i <= s - p; i++) {
            if (satisfiedDnaMinCount(minDna, result)) answer++;

            if (i < s - p) {
                result[dna[i]]--;
                result[dna[i + p]]++;
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

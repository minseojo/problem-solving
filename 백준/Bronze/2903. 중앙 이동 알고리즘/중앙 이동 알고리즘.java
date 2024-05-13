import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        int[] result = new int[16];
        int box = 1;
        int line = 1;
        result[0] = 4;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i - 1] + box * 5 - (line * (line - 1) * 2);
            box *= 4;
            line *= 2;
        }

        System.out.println(result[n]);
    }
    
}

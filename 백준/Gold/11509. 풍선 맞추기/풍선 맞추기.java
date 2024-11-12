import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[1_000_001];
        
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            
            if (a[h] > 0) {
                a[h]--;
            }
            a[h - 1]++;
        }

        for (int i : a) {
            answer += i;
        }

        System.out.println(answer);
    }
}
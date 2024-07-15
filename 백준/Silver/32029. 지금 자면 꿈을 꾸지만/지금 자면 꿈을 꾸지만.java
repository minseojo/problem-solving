import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(T);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < A; j++) {
                int time = 0, temp = 0;
                for (int k = 0; k < i; k++) {
                    if (time + A <= T[k]) {
                        time += A;
                        temp++;
                    }
                }
                time += B * j;
                for (int k = i; k < N; k++) {
                    if (time + A - j <= T[k]) {
                        time += (A - j);
                        temp++;
                    }
                }
                answer = Math.max(answer, temp);
            }
        }

        System.out.println(answer);

    }
}
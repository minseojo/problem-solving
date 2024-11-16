import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] ori = new int[n];
        List<int[]> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            ori[i] = x;
            a.add(new int[] {i, x});
        }

        a.sort((a1, a2) -> {
            if (a1[1] == a2[1]) Integer.compare(a1[0], a2[0]);
            return Integer.compare(a1[1], a2[1]);
        });

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[a.get(i)[0]] = i;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
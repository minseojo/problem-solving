import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            a.add(new int[] {x, i + 1});
        }

        a.sort((a1, a2) -> {
            if (a1[0] == a2[0]) return Integer.compare(a1[1], a2[1]);
            return Integer.compare(a1[0], a2[0]);
        });

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, a.get(i)[1] - i);
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());

        int[] S = new int[21];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            if (command.equals("add")) S[x] = 1;
            if (command.equals("remove")) S[x] = 0;
            if (command.equals("check")) sb.append(S[x] == 1 ? "1\n" : "0\n");
            if (command.equals("toggle")) {
                if (S[x] == 1) S[x] = 0;
                else S[x] = 1;
            }
            if (command.equals("all")) Arrays.fill(S, 1);
            if (command.equals("empty")) Arrays.fill(S, 0);
        }
        System.out.println(sb);
    }

}
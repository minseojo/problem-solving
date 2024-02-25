import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Data {
        int l;
        int r;

        Data(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        List<Data> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            a.add(new Data(l, r));
        }

        Collections.sort(a, (i, j) -> {
            if (i.l == j.l) {
                return Integer.compare(i.r, j.r);
            }
            return Integer.compare(i.l, j.l);
        });

        int posL = Integer.MIN_VALUE;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            Data d = a.get(i);
            int l = d.l;
            int r = d.r;

            if (posL >= r) {
                continue;
            }

            if (posL < l) {
                posL = l;
            }

            answer += (r - posL);
            posL = Math.max(posL, r);
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        int[] result = new int[2];

        if (((p + t) / w) % 2 == 0) { // 우
            result[0] = (p + t) % w;
        } else { // 좌
            result[0] = w - ((p + t) % w);
        }

        if (((q + t) / h) % 2 == 0) { // 상
            result[1] = (q + t) % h;
        } else { // 하
            result[1] = h - ((q + t) % h);
        }

        StringBuilder sb = new StringBuilder(result[0] + " " + result[1]);
        System.out.println(sb);
    }
}
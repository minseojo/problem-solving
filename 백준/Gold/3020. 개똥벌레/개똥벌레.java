import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] up = new int[n / 2];
        int[] down = new int[n / 2];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                up[i / 2] = x;
            } else {
                down[i / 2] = x;
            }
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= h; i++) {
            int conflict =  binarySearch(0, n / 2, up, i) + binarySearch(0, n / 2, down, h - i + 1);
            if (conflict < min) {
                min = conflict;
                count = 1;
            } else if (conflict == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }

    static int binarySearch(int l, int r, int[] a, int target) {
        while (l < r) {
            int m = (l + r) / 2;

            if (a[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return a.length - r;
    }
}
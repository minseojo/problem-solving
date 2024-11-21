import java.util.*;
import java.io.*;
import java.util.concurrent.DelayQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[w];
        for (int i = 0; i < w; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(h, w, a));
    }

    static int solution(int h, int w, int[] a) {
        int answer = 0;

        for (int i = 0; i < w; i++) {
            int l = a[i];
            int r = a[i];
            
            for (int j = 0; j < i; j++) {
                l = Math.max(l, a[j]);
            }
            for (int j = i; j < w; j++) {
                r = Math.max(r, a[j]);
            }
         
            answer += (Math.min(l, r) - a[i]);
        }

        return answer;
    }

}
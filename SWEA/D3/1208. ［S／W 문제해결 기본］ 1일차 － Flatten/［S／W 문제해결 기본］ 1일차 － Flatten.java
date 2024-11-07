import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[100];
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                maxPQ.add(a[i]);
                minPQ.add(a[i]);
            }

            for (int i = 0; i < n; i++) {
                maxPQ.add(maxPQ.poll() - 1);
                minPQ.add(minPQ.poll() + 1);
            }

            System.out.println("#" + tc + " " + (maxPQ.peek() - minPQ.peek()));
        }
    }
}
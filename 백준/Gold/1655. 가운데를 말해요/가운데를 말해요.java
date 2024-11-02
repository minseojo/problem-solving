import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (maxPQ.size() > minPQ.size()) {
                minPQ.offer(x);
            } else {
                maxPQ.offer(x);
            }

            if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                minPQ.offer(maxPQ.poll());
                maxPQ.offer(minPQ.poll());
            }

            System.out.println(maxPQ.peek());
        }
    }
}